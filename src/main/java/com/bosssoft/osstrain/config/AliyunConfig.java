package com.bosssoft.osstrain.config;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:aliyun.properties")
@ConfigurationProperties(prefix = "aliyun")
@Data
public class AliyunConfig {

    String endpoint;
    String accessKeyId;
    String accessKeySecret;
    String bucketName;
    String urlPrefix;

    @Bean
    public OSS ossClient(){
        return new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

}
