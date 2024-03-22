package com.molaei.controllers;

import com.molaei.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/product")
public class ProductController {

    List<ProductDTO> productDTOS = new ArrayList<ProductDTO>()
    {{
        add(new ProductDTO(102,"benz",1000, "home"));
        add(new ProductDTO(21,"toyota",2000, "work"));
    }};

    @Autowired
    Logger logger;

    @Autowired
    MessageSource source;

//    Logger logger = Logger.getLogger(ProductController.class);

    @GetMapping("/show")
    public String show(@ModelAttribute("dto") ProductDTO productDTO){
        return "product-show";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("dto") @Valid ProductDTO productDTO, BindingResult bindingResult, Locale locale){

//        source.getMessage("error.name", new Locale(locale.getCountry()));

        if (bindingResult.hasErrors()){
            return "product-show";
        }
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
