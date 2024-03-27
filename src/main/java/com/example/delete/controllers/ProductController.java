package com.example.delete.controllers;

import com.example.delete.dao.*;
import com.example.delete.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

	
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Product>> findAll(){
     List<Product> allProducts = productService.findAll();
     return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id){
        Optional<Product> product = productService.findById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Product> add(@RequestBody Product product){
        Product addedProduct = this.productService.add(product);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<Product> update(@RequestBody Product product){
        Optional<Product> existingProduct = this.productService.findById(product.getId());
        Product updatedProduct = product;
        if(existingProduct.isPresent()){
            updatedProduct = this.productService.update(product);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        Optional<Product> existingProduct = this.productService.findById(id);
        if(existingProduct.isPresent()){
            this.productService.delete(existingProduct.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}