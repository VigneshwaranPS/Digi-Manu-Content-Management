package com.digimenu.Content.Management.service.serviceImplentation;

import com.digimenu.Content.Management.entity.PageContent;
import com.digimenu.Content.Management.repository.PageContentRepository;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PageContentServiceImplTest {

    @Autowired
    private PageContentRepository repository;

    @Test
    public void getAllPageContentByParentId(){
        List<PageContent> list = repository.getByParentId("9c97e889-dcb0-4e56-95bd-120588f9eadb");
        System.out.println("List : "+list);
    }


    @Test
    public void savePageContent() throws JSONException {

        JSONObject object = new JSONObject();
//        object.put("length","100");
//        object.put("breadth","200");
//        object.put("position","(100,200)");

        object.put("font_type","georgia");
        object.put("font_size","18");
        object.put("font_color","#234222");

        String attributes = object.toString();

        PageContent pageContent = PageContent.builder()
                .id(UUID.randomUUID().toString())
                .locationId("11111")
                .parentId("9c97e889-dcb0-4e56-95bd-120588f9eadb")
                .contentName("WELHEADER")
                .contentType("TEXT")
                .contentText("Welcome to A2B")
//                .mediaId(UUID.randomUUID().toString())
                .attributes(attributes)
                .build();

        repository.save(pageContent);
    }
}