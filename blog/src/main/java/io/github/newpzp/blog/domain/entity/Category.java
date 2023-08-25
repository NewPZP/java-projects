package io.github.newpzp.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
@TableName("category")
@Data
public class Category {
    private Long id;
    private String name;
    private String description;    
    // Getters, Setters, Constructors
}
