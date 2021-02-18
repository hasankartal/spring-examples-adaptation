package com.haydikodlayalim.dto;

import com.haydikodlayalim.entity.Adres;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class KisiDto {

    private Long id;

    private String adi;

    private String soyadi;

    private List<String> adresler;
}
