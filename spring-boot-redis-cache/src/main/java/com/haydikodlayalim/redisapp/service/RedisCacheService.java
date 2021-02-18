package com.haydikodlayalim.redisapp.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    @Cacheable(cacheNames = "mySpecialCache")
    public String longRunningMethod() throws InterruptedException {
        Thread.sleep(10000L);
        return "method calisti";
    }

    @CacheEvict(cacheNames = "mySpecialCache")
    public void clearCache() {
        System.out.println("Cache temizlendi");
    }
}
