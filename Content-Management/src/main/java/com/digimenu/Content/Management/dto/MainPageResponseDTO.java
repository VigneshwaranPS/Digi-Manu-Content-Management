package com.digimenu.Content.Management.dto;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainPageResponseDTO {

    private String id;
    private String locationId;
    private String contentName;
    private String attributes;
    private List<PageContentResponseDTO> pageContentResponseDTOS;

}
