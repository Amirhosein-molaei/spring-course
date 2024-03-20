package com.molaei.controllers;

import com.molaei.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    List<ProductDTO> productDTOS = new ArrayList<ProductDTO>()
    {{
        add(new ProductDTO(102,"benz",1000, "home"));
        add(new ProductDTO(21,"toyota",2000, "work"));
    }};
    Logger logger = Logger.getLogger(ProductController.class);

    @GetMapping("/show")
    public String show(@ModelAttribute("dto") ProductDTO productDTO){
        return "product-show";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("dto") ProductDTO productDTO){
//        SecureRandom random = new SecureRandom();
//        productDTO.setId(random.nextInt(1000));
        productDTOS.add(productDTO);
        logger.debug(productDTO);
        //TODO must persist dto in database
        return "redirect:/";
    }

    @GetMapping(value = "/get-all")
    public ModelAndView getAll(ModelAndView modelAndView){
        modelAndView.setViewName("product-list");
        modelAndView.getModelMap().addAttribute("list", productDTOS);
        return modelAndView;
    }

//    @GetMapping("/detail")
//    public String detailWithQueryString(@RequestParam("id") int dummy){
//        logger.debug(dummy);
//        return "product-detail";
//    }

    @GetMapping("/detail/{id}")
    public String detailWithPathParam(@PathVariable("id") int id){
        logger.debug(id);
        //TODO get the product and add it to model and then dispatch it ti the view
        return "product-detail";
    }
}
