package com.bosssoft.osstrain.vo;

import lombok.Data;

/**
 * 上传结果返回格式
 */
@Data
public class PicUploadResult {

    /**
     * 文件唯一标识
     */
    private String uid;
    /**
     * 文件名
     */
    private String name;
    /**
     * 文件状态
     * uploading done error remove
     */
    private String status;
    /**
     * 服务端响应内容
     */
    private String response;
}
