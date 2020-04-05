package com.smile.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileUploadController {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    private String uploadPath = "/Users/tony/Desktop/uploadFiles/";

    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest req) {

        boolean flag = uploadFile(uploadFile, req);
        if (flag) {
            return "上传成功";
        }

        return "上传失败！";
    }

    @PostMapping("/uploads") // 这里的参数名需要对应post请求的参数名
    public String uploads(MultipartFile[] uploadFiles, HttpServletRequest req) {

        boolean[] values = new boolean[uploadFiles.length];
        System.out.println("上传多文件：" + uploadFiles.length);
        for (int i = 0; i < values.length; i++) {
            MultipartFile file = uploadFiles[i];
            values[i] = uploadFile(file, req);
        }
        return Arrays.toString(values);
    }

    private boolean uploadFile(MultipartFile uploadFile, HttpServletRequest req) {
        // Mac测试路径是一个隐藏路径，并不是上下文路径
        //String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");
        String realPath = uploadPath;
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);

        System.out.println("folder: " + folder);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try {
            File destFile = new File(folder, newName);
            System.out.println("dest: " + destFile.getAbsolutePath());
            uploadFile.transferTo(destFile);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }



}
