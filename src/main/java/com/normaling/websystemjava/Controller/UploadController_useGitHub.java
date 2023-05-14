package com.normaling.websystemjava.Controller;

import com.normaling.websystemjava.Model.Result;
import com.normaling.websystemjava.Util.GithubUploader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
//@RequestMapping("/upload")
public class UploadController_useGitHub {
    @Autowired
    private GithubUploader githubUploader;

    @PostMapping
    public Result upload (MultipartFile image) throws IOException {
        String data=this.githubUploader.upload(image);
        return Result.success(data);
    }
}
