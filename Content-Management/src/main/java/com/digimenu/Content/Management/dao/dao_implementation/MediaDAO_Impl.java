package com.digimenu.Content.Management.dao.dao_implementation;


import com.digimenu.Content.Management.dao.MediaDAO;
import com.digimenu.Content.Management.entity.Media;
import com.digimenu.Content.Management.repository.MediaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MediaDAO_Impl implements MediaDAO {

    @Autowired
    private MediaRepository repository;

    @Override
    public List<Media> getAllMedia() {
        return repository.findAll();
    }

    @Override
    public List<Media> getContentByMediaId(String mediaId) {
        return repository.findAllByEntityId(mediaId);
    }
}
