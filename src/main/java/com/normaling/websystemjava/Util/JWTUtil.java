package com.normaling.websystemjava.Util;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Map;

public class JWTUtil {
    /**
     * 生成jwt
     * @param content 负载内容
     * @param password 签名密码
     * @param algorithm 加密采用的算法
     * @return
     */
    public static String genJWT(Map<String,Object> content,String password,SignatureAlgorithm algorithm,Date continueTime){
        String jwt=Jwts.builder()//生成jwt令牌
                .signWith(algorithm,password)//设置签名算法：参数1：加密算法，参数2：加密密钥，相当于密码
                .setClaims(content)//添加自定义数据(载荷）
                .setExpiration(continueTime)//设置令牌有效期：1h
                .compact();//封装jwt令牌
        return jwt;
    }

    /**
     * 解析jwt令牌
     * @param jwt jwt内容
     * @param password 签名密码
     * @return
     */
    public static Object[] ParseJwt(String jwt,String password){
        Object jwtData[]=new Object[2];
        Object header= Jwts.parser()
                .setSigningKey(password)//设置加密密钥
                .parse(jwt)//导入要解析的jwt字符串
                .getHeader();//获取载荷部分信息
        Object body= Jwts.parser()
                .setSigningKey(password)//设置加密密钥
                .parse(jwt)//导入要解析的jwt字符串
                .getBody();//获取载荷部分信息
        jwtData[0]=header;
        jwtData[1]=body;
        return jwtData;
    }
}
