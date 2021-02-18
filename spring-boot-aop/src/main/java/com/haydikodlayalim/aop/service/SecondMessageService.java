package com.haydikodlayalim.aop.service;

import org.springframework.stereotype.Service;

@Service
public class SecondMessageService {
    public void mesaj(String param) {
        System.out.println(param);
    }
}
