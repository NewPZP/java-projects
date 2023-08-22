package io.github.newpzp.blog.domain.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;


@TableName("portfolio_item")
@Data
public class PortfolioItem {
    private Long id;
    private Long portfolioId;
    private String title;
    private String description;
    private String mediaUrl; // This can be an URL to an image, video or any other media type
    private LocalDateTime createdAt;
    private Portfolio portfolio;
    
    // Getters, Setters, Constructors
}
