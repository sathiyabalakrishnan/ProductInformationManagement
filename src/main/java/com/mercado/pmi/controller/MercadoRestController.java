package com.mercado.pmi.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import com.mercado.pmi.model.Product;
import com.mercado.pmi.service.ProductService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = APPLICATION_JSON_UTF8_VALUE)
public class MercadoRestController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping(path = "/create", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> saveProduct(@RequestBody Product product) {
        productService.save(mapper.map(product, Product.class));
        return ResponseEntity
            .status(CREATED)
            .build();
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity
            .ok()
            .body(productService.getAll());
    }

    @PutMapping(path = "/update", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> updateProduct(@RequestBody Product product) {
        productService.update(mapper.map(product, Product.class));
        return ResponseEntity
            .ok()
            .build();
    }

    @GetMapping("/product")
    public ResponseEntity<Product> getProduct(@RequestParam long sku) {
        return ResponseEntity
            .ok()
            .body(productService
                .getProduct(sku)
                .get());
    }

}
