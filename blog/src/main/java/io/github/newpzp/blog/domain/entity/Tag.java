package io.github.newpzp.blog.domain.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName("tag")
@Data
public class Tag {
    private Long id;
    private String name;
    private List<Post> posts; // Posts that have this tag
    
    // Getters, Setters, Constructors
}
