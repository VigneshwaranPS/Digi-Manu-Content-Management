package com.digimenu.Content.Management.dao;

import com.digimenu.Content.Management.entity.Media;
import java.util.List;

public interface MediaDAO {
    List<Media> getAllMedia();

    List<Media> getContentByMediaId(String mediaId);
}
