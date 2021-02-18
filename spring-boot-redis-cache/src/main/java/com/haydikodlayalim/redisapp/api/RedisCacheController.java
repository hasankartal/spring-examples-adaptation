package com.haydikodlayalim.redisapp.api;

import com.haydikodlayalim.redisapp.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RedisCacheController {
    private int counter = 0;

    @Autowired
    private RedisCacheService redisCacheService;

    @GetMapping
    public String cacheControl() throws InterruptedException {
        if(counter == 5) {
            redisCacheService.clearCache();
            counter = 0;
        }
        counter++;
        return redisCacheService.longRunningMethod();
    }


}
