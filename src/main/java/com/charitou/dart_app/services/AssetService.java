package com.charitou.dart_app.services;

import com.charitou.dart_app.dto.AssetCreateRequest;
import com.charitou.dart_app.models.Asset;
import com.charitou.dart_app.models.AssetStatus;
import com.charitou.dart_app.models.Capability;
import com.charitou.dart_app.repositories.AssetRepository;
import com.charitou.dart_app.repositories.CapabilityRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssetService {

    private final AssetRepository repository;
    private final CapabilityRepository capabilityRepository;

    public Asset create(@Valid AssetCreateRequest dto) {

        Asset asset = Asset.builder()
                .title(dto.title())
                .type(dto.type())
                .status(dto.status() != null ? dto.status(): AssetStatus.READY)
                .build();

        return repository.save(asset);
    }

    public Page<Asset> getaAllAssets(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Asset> getaAssetsByStatus(AssetStatus status, Pageable pageable) {
        return repository.findByStatus(status, pageable);
    }

    @Transactional
    public void addCapabilityToAsset(UUID assetId, UUID capabilityId) {
        Asset asset = repository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        Capability capability = capabilityRepository.findById(capabilityId)
                .orElseThrow(() -> new RuntimeException("Capability not found"));

        asset.addCapability(capability);

        repository.save(asset);
    }

    @Transactional
    public void removeCapabilityFromAsset(UUID assetId, UUID capabilityId) {
        Asset asset = repository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        Capability capability = capabilityRepository.findById(capabilityId)
                .orElseThrow(() -> new RuntimeException("Capability not found"));

        asset.removeCapability(capability);

        repository.save(asset);
    }

    public Page<Asset> getAssetsByCapability(String name, Pageable pageable) {
        return repository.findByCapabilities_Name(name, pageable);
    }
}
