package com.digimenu.Content.Management.dao.dao_implementation;

import com.digimenu.Content.Management.dao.PageContentDAO;
import com.digimenu.Content.Management.entity.PageContent;
import com.digimenu.Content.Management.repository.PageContentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PageContentDAO_Impl implements PageContentDAO {

    @Autowired
    private PageContentRepository repository;

    @Override
    public List<PageContent> getAllPageContent() {
        return repository.findAll();
    }

    @Override
    public List<PageContent> getPageContentByParentId(String parentId) {
        return repository.getByParentId(parentId);
    }
}
