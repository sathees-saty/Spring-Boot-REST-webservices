package com.example.delete.services;

import com.example.delete.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public Product add(Product product){
        return this.productRepository.add(product);
    }

    public Product update(Product product){
        return this.productRepository.update(product);
    }

    public void delete(Product product){
        this.productRepository.delete(product);
    }
}