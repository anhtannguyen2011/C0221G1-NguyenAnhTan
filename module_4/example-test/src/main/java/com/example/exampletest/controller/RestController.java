package com.example.exampletest.controller;

import com.example.exampletest.model.entity.Product;
import com.example.exampletest.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RequestMapping("/api")
@org.springframework.web.bind.annotation.RestController
@CrossOrigin
public class RestController {

    @Autowired
    IProductService productService;
    @GetMapping ("/view")
    public ResponseEntity<Product> showProduct(@RequestParam int id){
        Product product = this.productService.showProduct(id);
        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
