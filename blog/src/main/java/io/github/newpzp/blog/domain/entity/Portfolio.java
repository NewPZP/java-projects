package io.github.newpzp.blog.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName("portfolio")
@Data
public class Portfolio {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private Long userId; // Assuming the portfolio belongs to a user
    private User user;
    private List<PortfolioItem> items;
    
    // Getters, Setters, Constructors
}
