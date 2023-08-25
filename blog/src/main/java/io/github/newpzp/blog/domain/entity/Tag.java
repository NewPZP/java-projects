package io.github.newpzp.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("tag")
@Data
public class Tag {
    private Long id;
    private String name;
    
    // Getters, Setters, Constructors
}
