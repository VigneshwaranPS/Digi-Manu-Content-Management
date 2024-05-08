package com.digimenu.Content.Management.dao;

import com.digimenu.Content.Management.entity.PageContent;
import java.util.List;

public interface PageContentDAO {

    List<PageContent> getAllPageContent();

    List<PageContent> getPageContentByParentId(String parentId);
}
