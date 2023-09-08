package io.github.newpzp.blog.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryPostDTO {
    String searchTxt;
    List<String> tags;
    String category;
    private LocalDateTime createdStart;
    private LocalDateTime createdEnd;
    
    Long current;
    Long offset;
}
