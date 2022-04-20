package com.lee.ssm.common;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author lee
 * @version 2022/4/19 20:25
 * @since JDK8
 */

public class Msg<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    public static <T>  Msg<T> success(T data){
        return new Msg<T>(10001, "success", data);
    };


    public Msg() {
    }

    public Msg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDate() {
        return data;
    }

    public void setDate(T data) {
        this.data = data;
    }

    public Msg(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
