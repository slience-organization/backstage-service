package com.smart.star.service.serviceImpl;

import com.smart.star.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @Author：yjw
 * @Date：2021/6/10
 * @Description: 文件业务实现类
 */
@Service
public class FileServiceImpl implements FileService {

    @Override
    public Boolean upload(MultipartFile file) {
        String OriginalFileName = file.getOriginalFilename();
        String fileName = System.currentTimeMillis()+"."+OriginalFileName.substring(OriginalFileName.lastIndexOf(".")+1);
        String filePath = "D:\\Uploads\\";
        File dest = new File(filePath+fileName);
        if(!dest.getParentFile().exists())
            dest.getParentFile().mkdir();
        try {
            file.transferTo(dest);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
