package com.bosssoft.osstrain.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.GetObjectRequest;
import com.bosssoft.osstrain.config.AliyunConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;


@Service
public class PicDownloadServiceIpml implements PicDowloadService {

    @Autowired
    private OSS ossClient;

    @Autowired
    private AliyunConfig aliyunConfig;

    @Override
    public void download(String filename) {

        File file = new File("D:\\image/image.jpg");
        ossClient.getObject(new GetObjectRequest(aliyunConfig.getBucketName(),filename), file);

            ossClient.shutdown();
        }
    }

