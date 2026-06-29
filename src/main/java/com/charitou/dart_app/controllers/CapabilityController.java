package com.charitou.dart_app.controllers;

import com.charitou.dart_app.models.Capability;
import com.charitou.dart_app.services.CapabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/capabilities")
@RequiredArgsConstructor
public class CapabilityController {
    private final CapabilityService service;

    @PostMapping
    public ResponseEntity<Capability> create(@RequestBody Capability capability) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(capability));
    }

    @GetMapping
    public ResponseEntity<List<Capability>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
