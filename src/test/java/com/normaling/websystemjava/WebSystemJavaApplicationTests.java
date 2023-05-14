package com.normaling.websystemjava;

import com.normaling.websystemjava.Util.JWTUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class WebSystemJavaApplicationTests {
    @Test
    void testJWTUtil() {
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");
        Date date = new Date(System.currentTimeMillis() + 3600 * 1000);
        String jwt = JWTUtil.genJWT(claims, "NORMALING", SignatureAlgorithm.HS256,date);
        System.out.println(jwt);
    }
    @Test
    void testJWTUtil2(){
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");
        Date date = new Date(System.currentTimeMillis() + 3600 * 1000);
        String jwt = JWTUtil.genJWT(claims, "NORMALING", SignatureAlgorithm.HS256,date);
        Object[] normalings = JWTUtil.ParseJwt(jwt, "NORMALING");
        for (Object normaling : normalings) {
            System.out.println(normaling);
        }
    }

}
