package com.ouyu.tech.team_oil.common_oil.util;

import com.ouyu.tech.team_oil.common_oil.entity.OilClaims;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@Slf4j
public class CommonJwtUtil {
    @Value("${jwt.encrypt.key:}")
    private String key;

    @Value("${jwt.encrypt.expire-time-in-second:}")
    private String expireTimeInSecond;

    private JwtUtil jwtUtil;

    /**
     * 构建Jwt工具
     *
     * @author ouyu
     */
    private JwtUtil build() {
        if (jwtUtil == null) {
            synchronized (this) {
                if (jwtUtil == null) {
                    jwtUtil = JwtUtil.encodeStyle(key);
                    //jwtUtil.setExpirationTimeInSecond(Integer.valueOf(expireTimeInSecond));
                }
            }
        }
        return jwtUtil;
    }

    /**
     * 生成token
     *
     * @author ouyu
     */
    public String generateToken(OilClaims claims) {
        claims.setExpiration(build().getExpirationDate(Integer.valueOf(expireTimeInSecond)))
                .setIssuedAt(new Date());
        if (claims.getIssuer() == null) {
            claims.setIssuer(UserThreadUtil.getUserId().toString());
        }
        return build().generateToken(claims);
    }

    public Jws<Claims> resolverToken(String token){
        try {
            return  build().parserToken(token);
        } catch (Exception e) {
            log.error("解析Token错误[{}]",e);
            throw e;
        }
    }

}
