package com.charitou.dart_app.repositories;

import com.charitou.dart_app.models.Asset;
import com.charitou.dart_app.models.AssetStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AssetRepository extends JpaRepository<Asset, UUID> {

    Page<Asset> findByStatus(AssetStatus status, Pageable pageable);

    Page<Asset> findByCapabilities_Name(String name, Pageable pageable);
}
