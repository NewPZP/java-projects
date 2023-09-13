package io.github.newpzp.blog.domain.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Table("post_tags")
@Builder
public class PostTag {
    
    @Column("post_id")
    private Long postId;
    @Column("tag_id")
    private Integer tagId;
}
