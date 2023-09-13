package io.github.newpzp.blog.domain.entity;


import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import lombok.Builder;
import lombok.Data;

@Table("category")
@Data
@Builder
public class Category {
    @Id(keyType = KeyType.Auto)
    private Integer id;
    private String name;
    private String description;    
    // Getters, Setters, Constructors
}
