package com.molaei.service;

import com.molaei.models.ProductDTO;

import java.util.List;

public interface ProductService {
    void save(ProductDTO dto);

    List<ProductDTO> findAll();

    void delete(ProductDTO.DELETE id);
}
