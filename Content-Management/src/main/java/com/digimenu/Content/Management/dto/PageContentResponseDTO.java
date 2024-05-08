package com.digimenu.Content.Management.dto;


import com.digimenu.Content.Management.entity.Media;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageContentResponseDTO {

    private String parentId;
    private String contentName;
    private String contentType;
    private String contentText;
    private String attributes;
    private List<Media> medias;

}
