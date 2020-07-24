package com.bosssoft.osstrain.service;

import com.aliyun.oss.OSS;
import com.bosssoft.osstrain.config.AliyunConfig;
import com.bosssoft.osstrain.vo.PicUploadResult;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.IOException;


@Service
public class PicUploadServiceIpml implements PicUploadService{

    @Autowired
    private OSS ossClient;

    @Autowired
    private AliyunConfig aliyunConfig;

    /**
     * 允许上传的图片格式
     */
    public static final String[] IMAGE_TYPE = new String[]{".bmp",".jpg",
    ".jpeg",".gif",".png"};

    @Override
    public PicUploadResult upload(MultipartFile multipartFile){

        PicUploadResult uploadResult = new PicUploadResult();

        /**
         * 校验图片文件后缀名
         */
        boolean isLegal = false;
        for(String type : IMAGE_TYPE){
            if(StringUtils.endsWithIgnoreCase(multipartFile.getOriginalFilename(),type)){
                isLegal = true;
                break;
            }

        }
        if(!isLegal){
            uploadResult.setStatus("error");
            return uploadResult;
        }

        /**
         * 设定文件新路径
         */
        String fileName = multipartFile.getOriginalFilename();
        String filePath = this.getFilePath(fileName);

        /**
         * 上传阿里云
         */
        try {
            this.ossClient.putObject(this.aliyunConfig.getBucketName(),filePath,new ByteArrayInputStream(multipartFile.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
            uploadResult.setStatus("error");
            return uploadResult;
        }

        uploadResult.setStatus("done");
        uploadResult.setName(this.aliyunConfig.getUrlPrefix() + filePath);
        uploadResult.setUid(String.valueOf(System.currentTimeMillis()));

        ossClient.shutdown();

        return uploadResult;
    }

    /**
     * 重新设定文件路径的方法
     * @param fileName
     * @return filePath
     */
    private String getFilePath(String fileName) {
        DateTime dateTime = new DateTime();
        return "images/" + dateTime.toString("yyyy")
                + "/" + dateTime.toString("MM") + "/"
                + dateTime.toString("dd") + "/" + System.currentTimeMillis() +
                (int)(Math.random() * 1000) + "." + fileName.substring(fileName.lastIndexOf(".")+1);
    }
}
