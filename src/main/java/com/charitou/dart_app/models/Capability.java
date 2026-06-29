package com.charitou.dart_app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="capabilities")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Capability {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    @ManyToMany(mappedBy = "capabilities")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<Asset>  assets = new HashSet<>();
}
