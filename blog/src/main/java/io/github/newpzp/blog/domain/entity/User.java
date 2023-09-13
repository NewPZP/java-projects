package io.github.newpzp.blog.domain.entity;

import java.time.LocalDateTime;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import lombok.Data;

@Table("users")
@Data
public class User {
    
    @Id(keyType = KeyType.Auto)    private Long id;
    private String username;
    private String password;  // 注意: 在实际使用中，不要在应用中直接存储或显示真实密码
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    // Getters, Setters, Constructors
}
