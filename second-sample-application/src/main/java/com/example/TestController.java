package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tests")
@Slf4j
public class TestController {

    @GetMapping
    public ResponseEntity getTest(@RequestParam(required = false, name = "name", defaultValue = "def") String name) {
        log.info("Second service called");
        return new ResponseEntity<>(name, HttpStatus.OK);
    }


}