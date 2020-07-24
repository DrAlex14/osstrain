package com.bosssoft.osstrain.controller;

import com.bosssoft.osstrain.service.PicUploadService;
import com.bosssoft.osstrain.vo.PicUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/pic")
public class PicUploadController {

    @Autowired
    PicUploadService picUploadService;

    @ResponseBody
    @PostMapping("/upload")
    public PicUploadResult upload(@RequestParam("file")MultipartFile multipartFile){
        return picUploadService.upload(multipartFile);
    }
}
