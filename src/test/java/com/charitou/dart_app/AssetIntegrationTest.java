package com.charitou.dart_app;

import com.charitou.dart_app.dto.AssetCreateRequest;
import com.charitou.dart_app.models.AssetStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AssetIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldCreateNewAsset() {
        AssetCreateRequest request = new AssetCreateRequest("Falcon-11", "LAUNCHER", AssetStatus.READY);

        webTestClient.post()
                .uri("/api/assets")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isCreated();
    }
}