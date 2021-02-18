package com.haydikodlayalim.api;

import com.haydikodlayalim.entity.Kullanici;
import com.haydikodlayalim.repository.KullaniciRepository;
import com.mongodb.client.FindIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/kullanici")
public class KullaniciApi {
    @Autowired
    private KullaniciRepository kullaniciRepository;

    @PostConstruct
    public void init() {
        Kullanici kullanici = new Kullanici();
        kullanici.setAdi("Esme");
        kullanici.setSoyadi("Kartal");
        kullaniciRepository.save(kullanici);
    }

    @PostMapping
    public ResponseEntity<Kullanici> ekle(@RequestBody Kullanici kullanici) {
        return ResponseEntity.ok(kullaniciRepository.save(kullanici));
    }

    @GetMapping
    public ResponseEntity<List<Kullanici>> tumunuListele() {
        return ResponseEntity.ok(kullaniciRepository.findAll());
    }

}
