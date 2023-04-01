package com.xxd.codeexecutionflow.executionflow.base1;

import com.alibaba.fastjson.JSONObject;

public class BaseBusinessException extends Exception{
    private int code = 1;
    private Object extraData = "";

    public BaseBusinessException() {
        super();
    }
    public BaseBusinessException(String message) {
        super(message);
    }
    public BaseBusinessException(int code, String message) {
        super(message);
        this.code = code;
    }
    public BaseBusinessException(int code, String message, Object o) {
        super(message);
        this.code = code;
        this.extraData = o;
    }
    public BaseBusinessException(String message, Object o) {
        super(message);
        this.extraData = o;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getExtraData() {
        return extraData;
    }

    public void setExtraData(Object extraData) {
        this.extraData = extraData;
    }

    @Override
    public String toString() {
        JSONObject jo = new JSONObject();
        jo.put("code",code);
        jo.put("msg",this.getMessage());
        jo.put("data",extraData);
        return jo.toString();
    }
}
