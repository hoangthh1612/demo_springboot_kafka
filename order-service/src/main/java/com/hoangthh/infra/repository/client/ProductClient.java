package com.hoangthh.infra.repository.client;

import com.hoangthh.core.domain.ProductBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ProductClient {
    private final RestTemplate restTemplate;

    public boolean checkAvailability(ProductBody productBody) {
        ResponseEntity<Boolean> res = restTemplate.postForEntity("http://localhost:8082/api/product/check-availability", productBody, Boolean.class);
        return res.getBody();
    }
}
