package com.ouyu.tech.team_oil.common_oil.util;

import java.security.PublicKey;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-09 17:04
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
public class UserThreadUtil {
    private static ThreadLocal<Integer> userThread = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    public static Integer getUserId() {
        if (userThread.get() == -1) {
            throw new IllegalArgumentException("未设置用户Id");
        }
        return userThread.get();
    }

    public static void setUserId(Integer userId) {
        if(null == userId || userId == -1){
            throw new IllegalArgumentException("请设置正确的用户Id");
        }
        userThread.set(userId);
    }

    public static void remove(){
        userThread.remove();
    }
}
