package com.ouyu.tech.team_oil.common_oil.util;

import com.baomidou.mybatisplus.core.toolkit.EncryptUtils;
import org.springframework.util.DigestUtils;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-09 16:48
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
public class EncryptUtil {

    public static String encryptMd5(String chars,String salt){
       return DigestUtils.md5DigestAsHex((chars+salt).getBytes());
    }
}
