package com.normaling.websystemjava.Util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private static String signKey="normaling";

    private static long expire=43200000L;
    private static SignatureAlgorithm algorithm=SignatureAlgorithm.HS256;

    /**
     * 生成jwt令牌
     * @param claims JWT第二部分荷载payload中存储的内容
     * @return
     */
    public static String generateJwt(Map<String,Object> claims){
        String jwt=Jwts.builder()
                .addClaims(claims)
                .signWith(algorithm,signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        return jwt;
    }

    /**
     * 解析jwt令牌
     * @param jwt jwt内容
     * @return
     */
    public static Claims ParseJwt(String jwt){
        Claims claims=Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
