package com.charitou.dart_app.controllers;

import com.charitou.dart_app.dto.AssetCreateRequest;
import com.charitou.dart_app.models.Asset;
import com.charitou.dart_app.models.AssetStatus;
import com.charitou.dart_app.services.AssetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/assets")
@RequiredArgsConstructor
public class AssetsController {
    private final AssetService service;

    @PostMapping
    public ResponseEntity<Asset> create(@Valid @RequestBody AssetCreateRequest dto) {
        Asset saved = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAsset(@PathVariable UUID id) {
        service.deleteAsset(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public  ResponseEntity<Page<Asset>> getAll(@PageableDefault(size=20, sort = "title") Pageable pageable){
        Page<Asset> all_assets = service.getaAllAssets(pageable);
        return ResponseEntity.ok(all_assets);
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<Asset>> getByStatus(
            @RequestParam AssetStatus status,
            @PageableDefault(size=20, sort = "title") Pageable pageable) {

        Page<Asset> assets_by_status = service.getaAssetsByStatus(status, pageable);
        return ResponseEntity.ok(assets_by_status);
    }

    @PostMapping("/{assetId}/capabilities/{capabilityId}")
    public ResponseEntity<Void> addCapabilityToAsset(
            @PathVariable UUID assetId,
            @PathVariable UUID capabilityId) {
        service.addCapabilityToAsset(assetId, capabilityId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{assetId}/capabilities/{capabilityId}")
    public ResponseEntity<Void> removeCapability(
            @PathVariable UUID assetId,
            @PathVariable UUID capabilityId) {

        service.removeCapabilityFromAsset(assetId, capabilityId);
        return ResponseEntity.noContent().build(); // 204 No Content confirms success
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Asset>> searchByCapability(
            @RequestParam String capabilityName,
            Pageable pageable) {
        return ResponseEntity.ok(service.getAssetsByCapability(capabilityName, pageable));
    }

}

