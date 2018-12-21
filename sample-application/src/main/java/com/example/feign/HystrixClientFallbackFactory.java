package com.example.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<SecondClient> {
    @Override
    public SecondClient create(final Throwable cause) {
        return name -> cause.getMessage();
    }
}
