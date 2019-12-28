package com.example.lewjun.base;

public class ApiResult<T> {
  private T data;
  private int code = 0;
  private String msg = "ok";

  public ApiResult() {}

  public ApiResult(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public ApiResult(T data) {
    this();
    this.data = data;
    if (data == null) {
      err();
    }
  }

  private void err() {
    code = -1;
    msg = "err";
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
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
}
