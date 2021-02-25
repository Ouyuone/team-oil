package com.ouyu.tech.team_oil.common_oil.exception;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-18 14:44
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
public class CaptchaValidErrorException extends RuntimeException{
    private int code;

    public CaptchaValidErrorException() {
        super("验证码错误");
        this.code = 999;
    }

    public CaptchaValidErrorException(String message) {
        super(message);
        this.code = 999;
    }

    public CaptchaValidErrorException(String message, int code) {
        super(message);
        this.code = code;
    }
}
