package com.zks.spring.security.login.model.vo;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * Created by Administrator on 2018/10/27.
 */
@JSONType
public class Response<T> {

    private T data;
    private String message;
    private Integer code;

    public Response(Object data, String message, Integer code) {
        this.data = (T) data;
        this.message = message;
        this.code = code;
    }

    public T getData(){
        return this.data;
    }


    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Response{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
