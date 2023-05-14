package com.normaling.websystemjava.Controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.normaling.websystemjava.Model.Result;
import com.normaling.websystemjava.Util.UploadGiteeImgBed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@Slf4j
public class UploadController {
    @PostMapping("/upload")
    public Result add(MultipartFile image) throws IOException {
        String originalFilename = image.getOriginalFilename();
        String targetURL = UploadGiteeImgBed.createUploadFileUrl(originalFilename);
        log.info("目标url：{}",targetURL);
        //请求体封装
        Map<String, Object> uploadBodyMap = UploadGiteeImgBed.getUploadBodyMap(image.getBytes());
        //借助HttpUtil工具类发送POST请求
        String JSONResult = HttpUtil.post(targetURL, uploadBodyMap);
        //解析响应JSON字符串
        JSONObject jsonObj = JSONUtil.parseObj(JSONResult);
        //请求失败
        if(jsonObj == null || jsonObj.getObj("commit") == null){
            return Result.error("请求失败");
        }
        //请求成功：返回下载地址
        JSONObject content = JSONUtil.parseObj(jsonObj.getObj("content"));
        String data = content.getObj("download_url").toString();
        return Result.success(data);
    }
}
