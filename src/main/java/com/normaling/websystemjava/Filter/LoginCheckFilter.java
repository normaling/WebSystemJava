package com.normaling.websystemjava.Filter;
import cn.hutool.json.JSONUtil;
import com.normaling.websystemjava.Model.Result;
import com.normaling.websystemjava.Util.JWTUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse resp=(HttpServletResponse) response;
        //1. 获取请求的url
        String url = req.getRequestURI();
        log.info("请求的url：{}",url);
        //2. 判断请求的url是否包含login，如果有，说明是登录操作，放行。
        if(url.contains("login")){
            log.info("登录操作，放行...");
            chain.doFilter(request,response);
            return;
        }
        //3. 获取请求头中的令牌(token)
        String jwt = req.getHeader("token");
        //4. 判断令牌是否存在，如果不存在，返回错误结果（没有登录）
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登录信息" );
            Result error=Result.error("NOT_LOGIN");
            String notLogin= JSONUtil.toJsonStr(error);//将对象转化为json字符串
            resp.getWriter().write(notLogin);//返回错误信息
            return;
        }
        //5. 解析token，如果解析失败，返回错误结果（未登录）
        try {
            JWTUtil.ParseJwt(jwt,"normaling");
        } catch (Exception e) {//解析失败
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录信息");
            Result error=Result.error("NOT_LOGIN");
            String notLogin= JSONUtil.toJsonStr(error);//将对象转化为json字符串
            resp.getWriter().write(notLogin);//返回错误信息
            return;
        }
        //6. 放行
        log.info("令牌合法，放行");
        chain.doFilter(request,response);
    }
}
