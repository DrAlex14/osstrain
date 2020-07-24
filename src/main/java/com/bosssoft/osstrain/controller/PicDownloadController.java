package com.bosssoft.osstrain.controller;

import com.bosssoft.osstrain.service.PicDowloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pic")
public class PicDownloadController {

    @Autowired
    PicDowloadService picDowloadService;

    @PostMapping("/download")
    @ResponseBody
    public void download(@RequestParam("filename")String filename){
       picDowloadService.download(filename);
    }
}
