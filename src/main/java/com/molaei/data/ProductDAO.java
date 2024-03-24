package com.molaei.data;

import com.molaei.data.entities.Product;

import java.util.List;

public interface ProductDAO {
    void save(Product product);

    List<Product> findAll();

    void delete(int id);
}
