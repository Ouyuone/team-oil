package com.ouyu.tech.team_oil.common_oil.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-02 14:26
 * @Description: 数据返回对象
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Data
@NoArgsConstructor
public class ResponseData<T> {

    private int code;
    private  T data;
    private String message;

    private ResponseData(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    private ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> ResponseData<T> ok(T data){
        return ok(0,data,"");
    }
    public static <T> ResponseData<T> ok(T data,String message){
        return ok(0,data,message);
    }

    public static <T> ResponseData<T> ok(int code, T data){
        return ok(code,data,"");
    }

    public static <T> ResponseData<T> ok(int code, T data, String message){
        return new ResponseData<>(code,data,message);
    }

    public static <T> ResponseData<T> fail(String message,int code){
        return new ResponseData<>(code,message);
    }

}
