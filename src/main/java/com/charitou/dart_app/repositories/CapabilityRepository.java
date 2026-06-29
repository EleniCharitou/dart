package com.charitou.dart_app.repositories;

import com.charitou.dart_app.models.Capability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CapabilityRepository extends JpaRepository<Capability, UUID> {

}
