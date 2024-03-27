package com.example.delete.dao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductRepository {
    private List<Product> products;

    public ProductRepository(){
        this.products = buildFakeProducts();
    }

    private List<Product> buildFakeProducts(){
        Product p1 = new Product();
        p1.setId(1L);
        p1.setName("Samsung");
        p1.setPrice(20.12);
        Product p2 = new Product();
        p2.setId(2L);
        p2.setName("iPhone");
        p2.setPrice(40.99);
        Product p3 = new Product();
        p3.setId(3L);
        p3.setName("Realme");
        p3.setPrice(7.98);
        Product p4 = new Product();
        p4.setId(5L);
        p4.setName("Redme");
        p4.setPrice(14.56);
        Product p5 = new Product();
        p5.setId(6L);
        p5.setName("Nothing");
        p5.setPrice(39.94);

        List<Product> fakeProducts = new ArrayList<>();
        fakeProducts.add(p1);
        fakeProducts.add(p2);
        fakeProducts.add(p3);
        fakeProducts.add(p4);
        fakeProducts.add(p5);
        return fakeProducts;
    }
    public List<Product> findAll(){
        return this.products;
    }
    /* GET */
    public Optional<Product> findById(Long id){
        Optional<Product> ret = Optional.empty();
        List<Product> filteredProducts = this.products.stream().filter(p -> Objects.equals(p.getId(), id)).collect(Collectors.toList());
        if(!filteredProducts.isEmpty()){
            ret = Optional.of(filteredProducts.get(0));
        }
        return ret;
    }
    /* POST */
    public Product add(Product product){
        Long maxId = findMaxId();
        product.setId(maxId + 1);
        this.products.add(product);
        return product;
    }
    /* PUT */
    public Product update(Product product){
        int index = this.indexOf(product);
        this.products.set(index, product);
        return product;
    }
    /* DELETE */
    public void delete(Product product){
        int index = this.indexOf(product);
        this.products.remove(index);
    }
    private Long findMaxId() {
        return this.products.stream().map(Product::getId).reduce(Long::max).orElse(0L);
    }
    private int indexOf(Product product) {
        int index = 0;
        for (Product p:this.products) {
            if(Objects.equals(product.getId(), p.getId()))
                return index;
            index++;
        }
        return -1;
    }
}
