package com.charitou.dart_app.dto;

import com.charitou.dart_app.models.AssetStatus;
import jakarta.validation.constraints.NotBlank;

public record AssetCreateRequest(
        @NotBlank(message = "Title is required") String title,
        @NotBlank(message = "Type is required") String type,
        AssetStatus status
) {}