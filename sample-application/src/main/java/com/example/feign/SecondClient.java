package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "second", fallbackFactory = HystrixClientFallbackFactory.class)
public interface SecondClient {

    @GetMapping("/second/tests")
    String getName(@RequestParam("name") final String name);

}
