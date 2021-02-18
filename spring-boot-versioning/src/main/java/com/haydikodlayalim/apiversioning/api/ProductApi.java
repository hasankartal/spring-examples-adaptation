package com.haydikodlayalim.apiversioning.api;

import com.haydikodlayalim.apiversioning.dto.ProductV1;
import com.haydikodlayalim.apiversioning.dto.ProductV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductApi {

    //URI Versioning

    //localhost:8048/api/v1/product
    @GetMapping(value = "/v1/product")
    public ResponseEntity<ProductV1> pathVersioningProductV1() {
        return ResponseEntity.of(Optional.of(new ProductV1("Path Product v1")));
    }

    //localhost:8048/api/v2/product
    @GetMapping(value = "/v2/product")
    public ResponseEntity<ProductV2> pathVersioningProductV2() {
        return ResponseEntity.of(Optional.of(new ProductV2("Path Product v2", BigDecimal.TEN)));
    }

    //Param Versioning

    //localhost:8048/api/param/product?apiVersion=1
    @GetMapping(value = "/param/product", params = "apiVersion=1")
    public ResponseEntity<ProductV1> paramVersioningProductV1() {
        return ResponseEntity.of(Optional.of(new ProductV1("Param Product v1")));
    }

    //localhost:8048/api/param/product?apiVersion=2
    @GetMapping(value = "/param/product", params = "apiVersion=2")
    public ResponseEntity<ProductV2> paramVersioningProductV2() {
        return ResponseEntity.of(Optional.of(new ProductV2("Param Product v2", BigDecimal.TEN)));
    }

    //Header Versioning
    //localhost:8048/api/header/product
    @GetMapping(value = "/header/product", headers = "X-API-VERSION=1")
    public ResponseEntity<ProductV1> headerVersioningProductV1() {
        return ResponseEntity.of(Optional.of(new ProductV1("Header Product v1")));
    }

    //localhost:8048/api/header/product
    @GetMapping(value = "/header/product", headers = "X-API-VERSION=2")
    public ResponseEntity<ProductV2> headerVersioningProductV2() {
        return ResponseEntity.of(Optional.of(new ProductV2("Header Product v2", BigDecimal.TEN)));
    }
}