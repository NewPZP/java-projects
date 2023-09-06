package io.github.newpzp.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Builder;
import lombok.Data;

@Data
@TableName("post_tags")
@Builder
public class PostTag {
    
    @TableField("post_id")
    private Long postId;
    @TableField("tag_id")
    private Integer tagId;
}
