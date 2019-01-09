package com.example;

import org.junit.Test;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class TestControllerTest {

    @Test
    public void getTest() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {

            }
        });

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
            System.out.println("Iteration - " + i);
            ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8881/sample/tests", String.class);
            System.out.println("Status code - " + forEntity.getStatusCode());
        }
    }
}
