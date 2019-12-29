package com.example.lewjun.base;

/** @author huiye 请求状态码 */
public enum EnumApiResultCode {
  /** 成功状态码 */
  SUCCESS(0, "成功"),
  /* 参数错误 1001-1999 */
  PARAM_IS_INVALID(1001, "参数无效"),
  PARAM_IS_BLANK(1002, "参数为空"),
  PARAM_DATA_FORMAT_INVALID(1003, "日期格式不对"),
  /* 用户错误 2001-2999 */
  USER_NOT_LOGGED_IN(2001, "登录过期，请重新登录。"),
  USER_LOGIN_FAIL(2002, "账号不存在或密码错误");
  private final int code;

  private final String msg;

  EnumApiResultCode(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
