package com.digimenu.Content.Management.service.serviceImplentation;

import com.digimenu.Content.Management.entity.Media;
import com.digimenu.Content.Management.repository.MediaRepository;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MediaServiceImplTest {

    @Autowired
    private MediaRepository repository;

    @Test
    public void saveMedia(){
        Media media = Media.builder()
                .id(UUID.randomUUID().toString())
                .entityType("POSTER3")
                .entityId("0906d1c5-8da0-40ad-a807-64e61a3d09de")
                .fileName("cms_"+"Image3_"+String.valueOf(System.currentTimeMillis()))
                .mimeType("img/png")
                .build();
        repository.save(media);
    }

    @Test
    public void getContenetByMediaId(){
        List<Media> mediaList = repository.findAllByEntityId("0906d1c5-8da0-40ad-a807-64e61a3d09de");
        System.out.println("Media List : "+mediaList);
    }

}