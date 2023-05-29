package com.normaling.websystemjava.interceptor;
import cn.hutool.json.JSONUtil;
import com.normaling.websystemjava.Model.Result;
import com.normaling.websystemjava.Util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    /**
     * 目标资源方法运行前运行，返回值true代表放行，false代表不放行。
     */
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        //1. 获取请求的url
        String url = req.getRequestURI();
        log.info("请求的url：{}",url);
        //2. 判断请求的url是否包含login，如果有，说明是登录操作，放行。(这不需要写，以为在配置类中放行了/login)
        if(url.contains("login")){
            log.info("登录操作,放行");
            return true;
        }
        //3. 获取请求头中的令牌(token)
        String jwt = req.getHeader("token");
        //4. 判断令牌是否存在，如果不存在，返回错误结果（没有登录）
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登录信息" );
            Result error=Result.error("NOT_LOGIN");
            String notLogin= JSONUtil.toJsonStr(error);//将对象转化为json字符串
            resp.getWriter().write(notLogin);//返回错误信息
            return false;
        }
        //5. 解析token，如果解析失败，返回错误结果（未登录）
        try {
            JwtUtil.ParseJwt(jwt);
        } catch (Exception e) {//解析失败
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录信息");
            Result error=Result.error("NOT_LOGIN");
            String notLogin= JSONUtil.toJsonStr(error);//将对象转化为json字符串
            resp.getWriter().write(notLogin);//返回错误信息
            return false;
        }
        //6. 放行
        log.info("令牌合法，放行");
        return true;
    }

    /**
     *目标方法运行之后运行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("放行后逻辑");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     *视图渲染完毕后运行，最后运行。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("渲染后逻辑");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
