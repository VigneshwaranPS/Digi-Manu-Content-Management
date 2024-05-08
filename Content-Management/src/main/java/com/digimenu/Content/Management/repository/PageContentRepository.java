package com.digimenu.Content.Management.repository;

import com.digimenu.Content.Management.entity.PageContent;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PageContentRepository extends JpaRepository<PageContent,String> {


    @Query(
            nativeQuery = true,
            value =  "select * from mh_page_content where parent_id = ?1"
    )
    List<PageContent> getByParentId(String id);
}
