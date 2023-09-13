package io.github.newpzp.blog.domain.entity;

import java.time.LocalDateTime;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import lombok.Builder;
import lombok.Data;

@Table("posts")
@Data
@Builder
public class Post {

    @Id(keyType = KeyType.Auto)
    private Long id;

    @Column("user_id")
    private Long userId;

    @Column("category_id")
    private Long categoryId;
    private String title;
    private String content;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    // Getters, Setters, Constructors
}
