package com.molaei.controllers;

import com.molaei.models.ProductDTO;
import com.molaei.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/product")
@Log4j
@AllArgsConstructor
public class ProductController {

    ProductService service;

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
        log.debug(productDTO);
        service.save(productDTO);
        return "redirect:/";
    }

    @GetMapping(value = "/get-all")
    public ModelAndView getAll(ModelAndView modelAndView){
        modelAndView.setViewName("product-list");
        List<ProductDTO> productDTOList = service.findAll();
        modelAndView.addObject("list", productDTOList);
        return modelAndView;
    }

//    @GetMapping("/detail")
//    public String detailWithQueryString(@RequestParam("id") int dummy){
//        logger.debug(dummy);
//        return "product-detail";
//    }

    @GetMapping("/detail/{id}")
    public String detailWithPathParam(@PathVariable("id") int id){
        log.debug(id);
        //TODO get the product and add it to model and then dispatch it ti the view
        return "product-detail";
    }

    @GetMapping("/delete")
    public String delete(ProductDTO.DELETE dto){
        service.delete(dto);
        return "redirect:/product/get-all";
    }
}
