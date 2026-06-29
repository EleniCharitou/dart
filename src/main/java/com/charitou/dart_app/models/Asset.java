package com.charitou.dart_app.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name="assets")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String type;

    @Enumerated(EnumType.STRING)
    private AssetStatus status;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "asset_cababilities",
            joinColumns = @JoinColumn(name= "asset_id"),
            inverseJoinColumns = @JoinColumn(name = "capability_id")
    )
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Capability> capabilities = new HashSet<>();

    public void addCapability(Capability capability) {
        this.capabilities.add(capability);
        capability.getAssets().add(this);
    }

    public void removeCapability(Capability capability) {
        this.capabilities.remove(capability);
        capability.getAssets().remove(this);
    }
}


