package com.digimenu.Content.Management.repository;

import com.digimenu.Content.Management.entity.Media;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Media,String> {

    List<Media> findAllByEntityId(String mediaId);
}
