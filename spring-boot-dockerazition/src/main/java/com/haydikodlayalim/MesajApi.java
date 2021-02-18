package com.haydikodlayalim;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesaj")
public class MesajApi {

    @GetMapping //http://localhost:8040/mesaj
    public String mesajVer() {
        return "Docker Image içinden Merhaba";
    }

}
