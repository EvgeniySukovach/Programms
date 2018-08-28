package com.esdnepr.WEB.controllers;

import com.esdnepr.services.DTO.ProductDTO;
import com.esdnepr.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final static Logger log = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(ProductDTO product){
        log.info("Create product:{} ", product);
        productService.create(product);
    }
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ProductDTO> getAll(){
        log.info("Get list of products");
        return productService.getAll();
    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void get(@PathVariable("id") Long id){
        log.info("Get product by id:{}, data:{}", id);
        productService.get(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") Long id, ProductDTO product){
        log.info("Update product id:{}, data:{}", id, product);
        productService.update(id, product);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        log.info("Delete product : {}", id);
        productService.delete(id);
    }
}
