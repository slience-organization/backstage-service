package com.smart.star.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author：yjw
 * @Date：2021/6/10
 * @Description: 文件业务接口
 */
public interface FileService {

    Boolean upload(MultipartFile file);

}
