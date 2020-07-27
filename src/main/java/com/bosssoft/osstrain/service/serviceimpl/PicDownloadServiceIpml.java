package com.bosssoft.osstrain.service.serviceimpl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.GetObjectRequest;
import com.bosssoft.osstrain.config.AliyunConfig;
import com.bosssoft.osstrain.service.PicDowloadService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.io.File;


@Service
@Log4j2
public class PicDownloadServiceIpml implements PicDowloadService {

    @Autowired
    private AliyunConfig aliyunConfig;

    @Override
    @Async //声明异步调用
    public void download(String filename) {
        log.info(Thread.currentThread().getName());

        OSS ossClient = aliyunConfig.getOssClient();

        File file = new File("D:\\image/image"+(int)(Math.random() * 1000)+".jpg");
        ossClient.getObject(new GetObjectRequest(aliyunConfig.getBucketName(),filename), file);

            ossClient.shutdown();
        }
    }

