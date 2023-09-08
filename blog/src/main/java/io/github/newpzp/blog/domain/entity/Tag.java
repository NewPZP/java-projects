package io.github.newpzp.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Builder;
import lombok.Data;

@TableName("tag")
@Data
@Builder
public class Tag {
    private Integer id;
    private String name;
    
    
    // Getters, Setters, Constructors
}
