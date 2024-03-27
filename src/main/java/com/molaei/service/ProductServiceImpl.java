package com.molaei.service;

import com.molaei.data.ProductDAO;
import com.molaei.data.entities.Product;
import com.molaei.models.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDAO productDAO;

    @Autowired
    ModelMapper mapper;

    public void save(ProductDTO dto) {
        Product product = mapper.map(dto, Product.class);
        productDAO.save(product);
    }

    public List<ProductDTO> findAll() {
        List<Product> products = productDAO.findAll();

        List<ProductDTO> productDTOList = products.stream()
                .map(product -> mapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
        return productDTOList;
    }

    @Override
    public void delete(ProductDTO.DELETE dto) {
        productDAO.delete(dto.getId());
    }
}
