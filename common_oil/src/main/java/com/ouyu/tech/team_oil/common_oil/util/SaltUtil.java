package com.ouyu.tech.team_oil.common_oil.util;

import com.baomidou.mybatisplus.core.toolkit.AES;
import io.jsonwebtoken.security.Keys;
import sun.security.krb5.internal.crypto.Aes256;

import javax.crypto.SecretKey;
import java.util.Random;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-09 15:44
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
public class SaltUtil {
    static Random  random = new Random();
    static char[] alphas = new char[26];
    static {
        //利于unicode存入26个小写的字母
        for(int i = 0; i < 26; i++){
            alphas[i] = (char)(97 + i);
        }
    }

    public static String getSalt(){
       return getSalt("");
    }
    public static String getSalt(String subStr){
        int nextInt = random.nextInt(Integer.MAX_VALUE);
        char alpha = alphas[(int)(Math.random()*26)];
        return generate32Byte(nextInt + "<="+subStr+"=>" + alpha);
    }

    /**
     * 生成长度为32的字符串
     * @author ouyu
     */
    private static String generate32Byte(String code) {
        int length = 32;
        if(code == null){
           throw new IllegalArgumentException();
        }
        if(code.length() >= 32){
            return code;
        }
        StringBuilder sb = new StringBuilder(code);
        for (int i = 0; i < (length - code.length()); i++) {
           sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        getSalt();
    }

}
