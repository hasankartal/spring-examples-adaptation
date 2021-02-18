package com.haydikodlayalim.controller;

import com.haydikodlayalim.dto.PetDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "Benim Api dokumantasyonum")
public class PetController {
    List<PetDto> petDtoList = new ArrayList<>();

    //http://localhost:8057/v2/api-docs
    //http://localhost:8057/swagger-ui.html
    //http://localhost:8057/pet
    @PostConstruct
    public void init() {
        petDtoList.add(new PetDto(1,"Test Pet",new Date()));
    }

    @PostMapping
    @ApiOperation(value = "Yeni Pet Ekleme metodu",notes = "Bu metodu dikkatli kullan")
    public ResponseEntity<PetDto> kaydet(@RequestBody @ApiParam(value = "hayvan") PetDto petDto) {
        petDtoList.add(petDto);
        return ResponseEntity.ok(petDto);
    }

    @GetMapping
    @ApiOperation(value = "Pet listesi metodu",notes = "Bu metodu tümünü getirir")
    public ResponseEntity<List<PetDto>> tumunuListele() {
        return ResponseEntity.ok(petDtoList);
    }

}
