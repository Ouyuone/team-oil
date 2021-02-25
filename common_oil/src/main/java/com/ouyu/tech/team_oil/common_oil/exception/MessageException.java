package com.ouyu.tech.team_oil.common_oil.exception;

import lombok.Data;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-09 14:44
 * @Description: 自定义消息异常
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Data
public class MessageException extends RuntimeException {
    private int code;

    public MessageException() {
        super();
    }

    public MessageException(String message) {
        super(message);
        this.code = 999;
    }

    public MessageException(String message,int code) {
        super(message);
        this.code = code;
    }

}
