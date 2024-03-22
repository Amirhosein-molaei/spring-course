package com.molaei.controllers;

import com.molaei.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product/rest")
public class ProductRestService {
    Logger logger = Logger.getLogger(ProductRestService.class);

    List<ProductDTO> productDTOS = new ArrayList<ProductDTO>()
    {{
        add(new ProductDTO(102,"benz",1000, "home"));
        add(new ProductDTO(21,"toyota",2000, "work"));
    }};

    @GetMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO detailWithPathParam(@PathVariable("id") int id){
        logger.debug(id);
        //TODO get the product and add it to model and then dispatch it ti the view
        return productDTOS.get(0);
    }
}
