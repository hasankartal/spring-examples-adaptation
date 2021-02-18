package com.haydikodlayalim.controller;

import com.haydikodlayalim.dto.KisiDto;
import com.haydikodlayalim.entity.Kisi;
import com.haydikodlayalim.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiController {
    private final KisiService kisiService;

    @PostMapping //http://localhost:8055/kisi -> Post
    public ResponseEntity<KisiDto> kaydet(@RequestBody KisiDto kisiDto) {
        return ResponseEntity.ok(kisiService.save(kisiDto));
    }

    @GetMapping  // http://localhost:8055/kisi -> Get
    public ResponseEntity<List<KisiDto>> tumunuListele() {
        return ResponseEntity.ok(kisiService.getAll());
    }

}
