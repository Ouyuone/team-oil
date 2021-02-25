package com.ouyu.tech.team_oil.common_oil.util;

import com.ouyu.tech.team_oil.common_oil.entity.OilClaims;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-07 14:11
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
public class JwtUtil {
    private SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;

    private  SecretKey key;

    //默认是30分钟
    private int expirationTimeInSecond = 1600;


    private Date getExpirationDate(){
        return new Date(System.currentTimeMillis() + expirationTimeInSecond * 1000);
    }

    public Date getExpirationDate(int expirationTimeInSecond){
        return new Date(System.currentTimeMillis() + expirationTimeInSecond * 1000);
    }

    public void setExpirationTimeInSecond(int expirationTimeInSecond) {
        this.expirationTimeInSecond = expirationTimeInSecond;
    }

    /**
     * 可自定义选择加密方式
     * @author ouyu
     */
    private JwtUtil(SignatureAlgorithm signatureAlgorithm,SecretKey key) {
        this.signatureAlgorithm = signatureAlgorithm;
        this.key = key;
    }

    /**
     * 使用默认加密方式Hs256
     * @author ouyu
     */
    public JwtUtil(String key) {
        this.key = Keys.hmacShaKeyFor(key.getBytes());
    }

    public JwtUtil() {
    }

    /**
     * 获取jwtUtil实例
     * @author ouyu
     */
    public static JwtUtil encodeStyle(String key){
        return new JwtUtil(key);
    }

    public String generateToken(Map<String,Object> map){
       return Jwts.builder()
               .signWith(key,this.signatureAlgorithm)
               .setClaims(map)
               .compact();
    }

    public String generateToken(OilClaims claims){
        return Jwts.builder()
                .signWith(key,this.signatureAlgorithm)
                .setClaims(claims)
                .compact();
    }

    public Jws<Claims> parserToken(String token){
       return Jwts.parserBuilder().setSigningKey(this.key).build().parseClaimsJws(token);
    }
}
