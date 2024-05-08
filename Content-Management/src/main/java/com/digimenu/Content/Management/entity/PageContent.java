package com.digimenu.Content.Management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "mh_page_content")
public class PageContent {
    @Id
    @Column(name = "id" , length = 36)
    private String id;
    @Column(name = "location_id" , length = 36)
    private String locationId;
    @Column(name ="parent_id" ,length = 36)
    private String parentId;
    @Column(name = "content_name" , length = 60)
    private String contentName;
    @Column(name = "content_type" , length = 20)
    private String contentType;
    @Column(columnDefinition = "TEXT")
    private String contentText;
    @Column(name = "media_id" , length = 36)
    private String mediaId;
    @Column(columnDefinition = "json")
    private String attributes;

}
