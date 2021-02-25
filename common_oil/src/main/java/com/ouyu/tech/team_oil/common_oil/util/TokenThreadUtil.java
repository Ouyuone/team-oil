package com.ouyu.tech.team_oil.common_oil.util;

import com.ouyu.tech.team_oil.common_oil.constant.DescribeConstant;
import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-20 16:45
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Slf4j
public class TokenThreadUtil {
    private static ThreadLocal<String> tokenThread = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return null;
        }
    };

    public static String getToken(){
        String token = tokenThread.get();
        if(token == null){
            log.error("请携带{}头信息", DescribeConstant.Header.X_CURRENT_TOKEN);
        }
        return token;
    }

    public static void setToken(String token){
        tokenThread.set(token);
    }

    public static void remove(){
        tokenThread.remove();
    }
}
