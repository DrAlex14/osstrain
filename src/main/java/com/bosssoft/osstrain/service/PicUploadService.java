package com.bosssoft.osstrain.service;

import com.bosssoft.osstrain.vo.PicUploadResult;
import org.springframework.web.multipart.MultipartFile;

public interface PicUploadService {

    PicUploadResult upload(MultipartFile multipartFile);
}
