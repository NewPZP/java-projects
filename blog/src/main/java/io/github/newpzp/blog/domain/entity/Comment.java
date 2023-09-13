package io.github.newpzp.blog.domain.entity;

import java.time.LocalDateTime;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import lombok.Data;

@Table("comment")
@Data
public class Comment {
    @Id(keyType = KeyType.Auto)
    private Long id;
    @Column("post_id")
    private Long postId;
    @Column("user_id")
    private Long userId;
    private String content;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
