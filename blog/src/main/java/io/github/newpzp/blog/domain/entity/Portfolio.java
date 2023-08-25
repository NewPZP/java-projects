package io.github.newpzp.blog.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName("portfolio")
@Data
public class Portfolio {
    @TableId
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;

    @TableField("urser_id")
    private Long userId; // Assuming the portfolio belongs to a user
    
    // Getters, Setters, Constructors
}
