package com.digimenu.Content.Management.service.serviceImplentation;

import com.digimenu.Content.Management.dao.MediaDAO;
import com.digimenu.Content.Management.dao.PageContentDAO;
import com.digimenu.Content.Management.dto.MainPageResponseDTO;
import com.digimenu.Content.Management.dto.PageContentResponseDTO;
import com.digimenu.Content.Management.entity.Media;
import com.digimenu.Content.Management.entity.PageContent;
import com.digimenu.Content.Management.service.DigiMenuService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DigiMenuServiceImpl implements DigiMenuService {



    @Autowired
    private PageContentDAO pageContentDAO;


    @Autowired
    private MediaDAO mediaDAO;


    public List<MainPageResponseDTO> getAllPageContent(){
        List<PageContent> pageContents = pageContentDAO.getAllPageContent();

        List<MainPageResponseDTO> mainPageResponseDTOS = new ArrayList<>();

        for(PageContent pageContent : pageContents){
            String id = pageContent.getId();
            List<PageContent> pageContentList = pageContentDAO.getPageContentByParentId(id);
            if(pageContentList != null){
                MainPageResponseDTO responseDTO = new MainPageResponseDTO();
                responseDTO.setId(pageContent.getId());
                responseDTO.setContentName(pageContent.getContentName());
                responseDTO.setLocationId(pageContent.getLocationId());
                responseDTO.setAttributes(pageContent.getAttributes());
                List<PageContentResponseDTO> pageContentResponseDTOS = new ArrayList<>();
                for(PageContent pageContent1 : pageContentList){
                    PageContentResponseDTO pageContentResponseDTO = new PageContentResponseDTO();
                    pageContentResponseDTO.setParentId(pageContent1.getParentId());
                    pageContentResponseDTO.setContentName(pageContent1.getContentName());
                    pageContentResponseDTO.setContentText(pageContent1.getContentText());
                    pageContentResponseDTO.setContentType(pageContent1.getContentType());
                    pageContentResponseDTO.setAttributes(pageContent1.getAttributes());
                    List<Media> medias = new ArrayList<>();
                    String mediaId = pageContent1.getMediaId();
                    List<Media> mediaList = mediaDAO.getContentByMediaId(mediaId);
                    for(Media media : mediaList){
                        Media media1 = Media.builder()
                                .mimeType(media.getMimeType())
                                .tag(media.getTag())
                                .entityType(media.getEntityType())
                                .fileName(media.getFileName())
                                .entityId(media.getEntityId())
                                .id(media.getId())
                                .sortOrder(media.getSortOrder())
                                .modifiedTime(new Date())
                                .createdTime(new Date())
                                .build();
                        medias.add(media1);
                    }
                    pageContentResponseDTO.setMedias(medias);
                    pageContentResponseDTOS.add(pageContentResponseDTO);
                }
                responseDTO.setPageContentResponseDTOS(pageContentResponseDTOS);
                mainPageResponseDTOS.add(responseDTO);
            }
        }
        return mainPageResponseDTOS;
    }
}
