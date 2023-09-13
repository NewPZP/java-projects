package io.github.newpzp.blog.domain.entity;

import java.time.LocalDateTime;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import lombok.Data;

@Table("portfolio")
@Data
public class Portfolio {

    @Id(keyType = KeyType.Auto)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;

    @Column("urser_id")
    private Long userId; // Assuming the portfolio belongs to a user
    
    // Getters, Setters, Constructors
}
