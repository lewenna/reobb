package com.reofixy.reobb.model.dto;

import com.reofixy.reobb.model.ContentLike;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private int id;
    private String title;
    private String content;
    private String categoryName;
    private String username;
}
