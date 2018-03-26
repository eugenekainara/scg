package com.example;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

import static org.junit.Assert.*;

public class TestControllerTest {

    private RestTemplate restTemplate = new RestTemplate();


    @org.junit.Test
    public void getTest() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
            System.out.println("Iteration - " + i);
            ResponseEntity<Object> forEntity = restTemplate.getForEntity("http://localhost:8881/sample/tests", Object.class);
            System.out.println("Status code - " + forEntity.getStatusCode());
        }
    }
}
