package io.github.newpzp.blog.domain.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;


@TableName("portfolio_item")
@Data
public class PortfolioItem {
    @TableId
    private Long id;

    @TableField("portfolio_id")
    private Long portfolioId;
    private String title;
    private String description;
    
    @TableField("media_url")
    private String mediaUrl; // This can be an URL to an image, video or any other media type
    private LocalDateTime createdAt;
    
    // Getters, Setters, Constructors
}
