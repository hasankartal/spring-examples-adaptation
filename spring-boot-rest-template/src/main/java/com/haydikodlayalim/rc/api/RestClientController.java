package com.haydikodlayalim.rc.api;

import com.haydikodlayalim.rc.model.KisiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/test")
public class RestClientController {

    private final static String webUrl = "http://localhost:8055/kisi";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping//http://localhost:8042/test
    public ResponseEntity<List<KisiDto>> getKisiList() {
        ResponseEntity<List> result = restTemplate.getForEntity(webUrl,  List.class);
        List<KisiDto> responseBody = result.getBody();
        System.out.println(result);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping
    public ResponseEntity<KisiDto> kaydet(@RequestBody KisiDto kisiDto) {
        ResponseEntity<KisiDto> result = restTemplate.postForEntity(webUrl, kisiDto, KisiDto.class);
        KisiDto responseBody = result.getBody();
        System.out.println(result);
        return ResponseEntity.ok(responseBody);
    }


}
