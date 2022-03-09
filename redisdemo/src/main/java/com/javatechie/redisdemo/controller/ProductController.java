package com.javatechie.redisdemo.controller;

import com.javatechie.redisdemo.entity.Product;
import com.javatechie.redisdemo.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product/api/v1")
public class ProductController {

    @Autowired
    ProductDao dao;

    @PostMapping("/save")
    public Product save(@RequestBody  Product product)
    {
        return dao.save(product);
    }


    @GetMapping("/findall")
    public List<Product> findAll()
    {
        return dao.findAll();
    }


    @GetMapping("/{id}")
    public List<Product> findByid(@PathVariable int id)
    {
        return dao.findProductById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteById(@PathVariable int id)
    {
        return dao.deleteProduct(id);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

}
