package com.digimenu.Content.Management.controller;

import com.digimenu.Content.Management.dto.MainPageResponseDTO;
import com.digimenu.Content.Management.service.DigiMenuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MainController {

    @Autowired
    private DigiMenuService digiMenuService;

    @GetMapping
    public List<MainPageResponseDTO> getContent(){
        return digiMenuService.getAllPageContent();
    }

}
