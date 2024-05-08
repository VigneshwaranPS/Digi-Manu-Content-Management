package com.digimenu.Content.Management.service.serviceImplentation;

import com.digimenu.Content.Management.dao.PageContentDAO;
import com.digimenu.Content.Management.entity.PageContent;
import com.digimenu.Content.Management.service.PageContentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageContentServiceImpl implements PageContentService {

    @Autowired
    private PageContentDAO pageContentDAO;

    public List<PageContent> getAllPageContent(){
        return pageContentDAO.getAllPageContent();
    }
}
