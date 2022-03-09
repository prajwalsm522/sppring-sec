package com.javatechie.redisdemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "product")
public class Product implements Serializable {

    @Id
    private int id;
    private String name;
    private int qty;
    private int price;
}
