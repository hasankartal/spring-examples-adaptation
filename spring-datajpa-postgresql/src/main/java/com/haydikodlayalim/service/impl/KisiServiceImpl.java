package com.haydikodlayalim.service.impl;

import com.haydikodlayalim.dto.KisiDto;
import com.haydikodlayalim.entity.Adres;
import com.haydikodlayalim.entity.Kisi;
import com.haydikodlayalim.repo.AdresRepository;
import com.haydikodlayalim.repo.KisiRepository;
import com.haydikodlayalim.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {
    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;

    @Override
    @Transactional //Tek bir transaction da yapılır. Ya hepsini veritabanına kaydeder ya da geri alır.
    public KisiDto save(KisiDto kisiDto) {
        //Assert.isNull(kisiDto.getAdi(),"Adi alani zorunludur");

        Kisi kisi= new Kisi();
        kisi.setAdi(kisiDto.getAdi());
        kisi.setSoyadi(kisiDto.getSoyadi());
        final Kisi kisiDb = kisiRepository.save(kisi);

        List<Adres> liste = new ArrayList<>();
        kisiDto.getAdresler().forEach(item -> {
            Adres adres= new Adres();
            adres.setAdres(item);
            adres.setAdresTip(Adres.AdresTip.DIGER);
            adres.setAktif(true);
            adres.setKisi(kisiDb);
            liste.add(adres);
        });
        adresRepository.saveAll(liste);
        kisiDto.setId(kisiDb.getId());

        return kisiDto;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<KisiDto> getAll() {
        List<Kisi> kisiler = kisiRepository.findAll();
        List<KisiDto> kisiDtos = new ArrayList<>();
        kisiler.forEach(item -> {
            KisiDto kisiDto = new KisiDto();
            kisiDto.setId(item.getId());
            kisiDto.setAdi(item.getAdi());
            kisiDto.setSoyadi(item.getSoyadi());
            kisiDto.setAdresler(item.getAdresleri().stream().map(Adres::getAdres).collect(Collectors.toList()));
            kisiDtos.add(kisiDto);
        });
        return kisiDtos;
    }

    @Override
    public Page<KisiDto> getAllPagination(Pageable pageable) {
        return null;
    }
}
