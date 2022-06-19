package com.simpleblog.blog.controller;

import com.simpleblog.blog.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @PostMapping
    public Result upload(@RequestParam("image") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + "." +
                StringUtils.substringAfterLast(originalFilename, ".");
        byte[] bytes = Base64.encodeBase64(file.getBytes(), false);
        String image = "data:image/png;base64," + org.apache.tomcat.util.codec.binary.StringUtils.newStringUtf8(bytes);
        // TODO:: implement uploading to 3rd party hosting service
        return Result.success(null);
    }
}
