package com.digimenu.Content.Management.entity;


import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="mh_media")
public class Media {

    @Id
    @Column(name = "id" , length = 36)
    private String id;
    @Column(name = "entity_type", length = 64)
    private String entityType;
    @Column(name = "entity_id" , length = 36)
    private String entityId;
    @Column(name = "file_name", length = 128)
    private String fileName;
    @Column(name = "mime_type", length = 128)
    private String mimeType;
    @Column(name = "tag", length = 128)
    private String tag;
    private Integer sortOrder;
    private Date createdTime;
    private Date modifiedTime;
}
