package io.github.newpzp.blog.domain.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostDTO {

    private Long id;
    
    private String title;
    private String content;

    private Long categoryId;
    private List<String> tagNames;

}
