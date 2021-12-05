package com.mercado.pmi.service;

import com.mercado.pmi.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> save(Product event);

    List<Product> getAll();

    Optional<Product> update(Product product);

    Optional<Product> getProduct(long id);
}
