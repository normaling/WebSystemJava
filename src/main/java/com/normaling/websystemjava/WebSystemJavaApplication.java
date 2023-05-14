package com.normaling.websystemjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan//开启了对javaweb组件支持
@SpringBootApplication
public class WebSystemJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSystemJavaApplication.class, args);
    }

}
