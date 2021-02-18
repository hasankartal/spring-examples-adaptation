package com.haydikodlayalim.api;

import com.haydikodlayalim.entity.Kisi;
import com.haydikodlayalim.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kisi")
public class KisiController {

    private final KisiRepository kisiRepository;

    @PostConstruct
    public void init() {
        Kisi kisi = new Kisi();
        kisi.setAd("Asd");
        kisi.setSoyad("Kartal");
        kisiRepository.save(kisi);
    }

    /*
     * http://localhost:8056/kisi/Asd
     */

    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
        List<Kisi> kisiler = kisiRepository.getByCustomQuery(search);

        return ResponseEntity.ok(kisiler);
    }
    /*
    * http://localhost:8056/kisi/test/kartal
     */
    @GetMapping("/test/{search}")
    public ResponseEntity<List<Kisi>> getKisiAdOrSoyad(@PathVariable String search) {
        List<Kisi> kisiler = kisiRepository.findByAdLikeOrSoyadLike(search,search);

        return ResponseEntity.ok(kisiler);
    }
}
