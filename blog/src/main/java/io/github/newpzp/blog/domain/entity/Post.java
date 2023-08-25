package io.github.newpzp.blog.domain.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName("posts")
@Data
public class Post {

    @TableId
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("category_id")
    private Long categoryId;
    private String title;
    private String content;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    // Getters, Setters, Constructors
}
