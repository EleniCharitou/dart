package com.charitou.dart_app.services;

import com.charitou.dart_app.models.Capability;
import com.charitou.dart_app.repositories.CapabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CapabilityService {
    private final CapabilityRepository repository;

    public Capability create(Capability capability) {
        return repository.save(capability);
    }

    public List<Capability> getAll() {
        return repository.findAll();
    }
}
