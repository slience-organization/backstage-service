package com.smart.star.util;

import java.io.Serializable;

/**
 * @Author：yjw
 * @Date：2021/6/10
 * @Description: 响应结果工具类
 */
public class Result<T> implements Serializable {

    private static final int ok_code = 666;
    private static final String ok_t = "成功";
    private static final int fail_code = 999;

    private int code;
    private String msg;
    private T data;


    public Result() {

    }

    public static <T> Result<T> success(){
        Result<T> r = new Result<T>();
        r.setCode(ok_code);
        r.setMsg(ok_t);
        return r;
    }
    public static <T> Result<T> success(T data){
        Result<T> r = new Result<T>();
        r.setCode(ok_code);
        r.setMsg(ok_t);
        r.setData(data);
        return r;
    }
    public static <T> Result<T> fail(String msg){
        Result<T> r = new Result<T>();
        r.setCode(fail_code);
        r.setMsg(msg);
        return r;
    }

    //getter and setter
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
