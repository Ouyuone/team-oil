package com.ouyu.tech.message_oil.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-19 13:17
 * @Description: 发消息的工具类
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Slf4j
public class SendMessageUtil {
    private static Integer[] number = {0,1,2,3,4,5,6,7,8,9};
    private static Random random = new Random();

    /**
     * 模拟发短信
     * @author ouyu
     */
    public static String sendPhoneCaptcha(){
        StringBuilder sb = new StringBuilder();
          for(int i = 0; i<4;i++){
              int nextInt = random.nextInt(1000);
              int cop = nextInt % number.length;
              sb.append(number[cop]);
          }
       return sb.toString();
    }
}
