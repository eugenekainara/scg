package com.example;

import com.example.feign.SecondClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tests")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final SecondClient secondClient;
    private final TestConfig testConfig;

    @GetMapping
    public ResponseEntity getTest() {
        log.info("First service called");
        String name = secondClient.getName(testConfig.getName());
        return new ResponseEntity<>("Hello" + name, HttpStatus.OK);
    }

}