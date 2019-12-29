package com.example.lewjun.base;

import java.io.Serializable;

/** @author huiye */
public class ApiResult implements Serializable {
  private static final long serialVersionUID = -1779439177783657300L;
  private int code;
  private String msg;
  private Object data;

  private ApiResult() {}

  private ApiResult(EnumApiResultCode apiResultCode) {
    setResultCode(apiResultCode);
  }

  public static ApiResult success(Object data) {
    ApiResult apiResult = new ApiResult(EnumApiResultCode.SUCCESS);
    apiResult.setData(data);
    return apiResult;
  }

  public static ApiResult success() {
    return new ApiResult(EnumApiResultCode.SUCCESS);
  }

  public static ApiResult failure(EnumApiResultCode apiResultCode) {
    ApiResult apiResult = new ApiResult();
    apiResult.setResultCode(apiResultCode);
    return apiResult;
  }

  private void setResultCode(EnumApiResultCode apiResultCode) {
    code = apiResultCode.getCode();
    msg = apiResultCode.getMsg();
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
