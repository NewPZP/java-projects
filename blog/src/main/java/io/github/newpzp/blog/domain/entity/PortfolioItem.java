package io.github.newpzp.blog.domain.entity;

import java.time.LocalDateTime;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import lombok.Data;


@Table("portfolio_item")
@Data
public class PortfolioItem {

    @Id(keyType = KeyType.Auto)
    private Long id;

    @Column("portfolio_id")
    private Long portfolioId;
    private String title;
    private String description;
    
    @Column("media_url")
    private String mediaUrl; // This can be an URL to an image, video or any other media type
    private LocalDateTime createdAt;
    
    // Getters, Setters, Constructors
}
