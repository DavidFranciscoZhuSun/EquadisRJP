package com.equadis.RJP_bank_system.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public static <T> ResponseBean<T> success(T data) {
        ResponseBean<T> response = new ResponseBean<>();
        response.setCode(200);
        response.setMsg("Success");
        response.setData(data);
        return response;
    }

    public static <T> ResponseBean<T> error(String errorMsg) {
        ResponseBean<T> response = new ResponseBean<>();
        response.setCode(401);
        response.setMsg(errorMsg);
        response.setData(null);
        return response;
    }

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

