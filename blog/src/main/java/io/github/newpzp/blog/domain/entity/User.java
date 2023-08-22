package io.github.newpzp.blog.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName("user")
@Data
public class User {
    private Long id;
    private String username;
    private String password;  // 注意: 在实际使用中，不要在应用中直接存储或显示真实密码
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Post> posts;
    private List<Comment> comments;
    
    // Getters, Setters, Constructors
}
