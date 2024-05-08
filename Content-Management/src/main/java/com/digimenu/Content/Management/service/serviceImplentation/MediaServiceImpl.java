package com.digimenu.Content.Management.service.serviceImplentation;

import com.digimenu.Content.Management.dao.MediaDAO;
import com.digimenu.Content.Management.entity.Media;
import com.digimenu.Content.Management.service.MediaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaServiceImpl implements MediaService {


    @Autowired
    private MediaDAO mediaDAO;

    @Override
    public List<Media>  getAllMedia(){
        return mediaDAO.getAllMedia();
    }
}
