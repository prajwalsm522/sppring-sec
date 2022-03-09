package com.javatechie.redisdemo.repository;

import com.javatechie.redisdemo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    public static final String HASH_KEY = "Product";

    @Autowired
    private RedisTemplate redisTemplate;

    public Product save(Product product){
        redisTemplate.opsForHash().put(HASH_KEY ,product.getId(), product);
        return product;
//        Product product1 = new Product(1,"mouse",3,1200);
//        save(product1);
//        return product1;
    }

    public List<Product> findAll() {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public List<Product> findProductById(int id) {
        return (List<Product>) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public String deleteProduct(int id) {
         redisTemplate.opsForHash().delete(HASH_KEY,id);
         return "Product Deleted";
    }

}
