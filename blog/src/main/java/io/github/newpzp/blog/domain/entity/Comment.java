package io.github.newpzp.blog.domain.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("comment")
@Data
public class Comment {
    @TableId
    private Long id;
    @TableField("post_id")
    private Long postId;
    @TableField("user_id")
    private Long userId;
    private String content;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
