package com.example.demo.domain.BA0010.controller;

import com.example.demo.domain.BA0010.service.BA0010Service;
import com.example.demo.domain.BA0010.dto.BA0010Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class BA0010ManageController {

    @Autowired
    private BA0010Service BA0010Service;

    @GetMapping(value="/main")
    public String getBA0010() throws Exception {

        List<BA0010Dto> BA0010Api = BA0010Service.getApi();

        return BA0010Api.toString();
    }

    @PostMapping(value="/post")
    public String postBA0010(Model model) throws Exception {

        List<BA0010Dto> BA0010Api = BA0010Service.getApi();
        model.addAttribute("api", BA0010Api);

        return "";
    }
}
