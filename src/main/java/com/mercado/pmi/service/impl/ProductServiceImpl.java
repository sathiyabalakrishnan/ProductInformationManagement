package com.mercado.pmi.service.impl;

import com.mercado.pmi.model.Product;
import com.mercado.pmi.repository.ProductRepository;
import com.mercado.pmi.service.ProductService;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> save(Product product) {
        return Optional.of(productRepository.save(product));
    }

    @Override public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> update(Product product) {
        Optional<Product> persistedProduct = productRepository.findById(product.getId());
        if (persistedProduct.isPresent()) {
            if (Objects.equals(product.getId(), persistedProduct
                .get()
                .getId())) {
                return Optional.ofNullable(productRepository.save(product));
            }
        }
        return null;
    }

    @Override public Optional<Product> getProduct(long id) {
        return productRepository.findById(id);
    }

}
