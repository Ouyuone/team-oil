package com.ouyu.tech.team_oil.common_oil.util;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-19 08:43
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
public class ConvertUtil {
    static Logger log = LoggerFactory.getLogger(ConvertUtil.class);
    /**
     * 字符串转数字
     * @author ouyu
     * @date 2021-02-19
     * @param str
     * @return java.lang.Integer
     */
    public static Integer numberTo(String str){
        if(NumberUtils.isCreatable(str)){
            return Integer.valueOf(str);
        }
        log.error("不是数字不能转换");
        throw new IllegalArgumentException("不是数字不能转换");
    }
}
