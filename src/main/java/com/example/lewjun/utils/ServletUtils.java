package com.example.lewjun.utils;

import com.example.lewjun.base.ApiResult;
import com.example.lewjun.base.EnumApiResultCode;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** @author huiye */
public class ServletUtils {
  private static final Logger LOGGER = LoggerFactory.getLogger(ServletUtils.class);

  private static final String VIEW_PATH = "/WEB-INF/jsp/";
  private static final String VIEW_SUFFIX = ".jsp";

  public static void success(HttpServletResponse resp) throws IOException {
    toJson(resp, ApiResult.success());
  }

  public static void success(HttpServletResponse resp, Object data) throws IOException {
    toJson(resp, ApiResult.success(data));
  }

  public static void failure(HttpServletResponse resp, EnumApiResultCode apiResultCode)
      throws IOException {
    toJson(resp, ApiResult.failure(apiResultCode));
  }

  private static void toJson(HttpServletResponse resp, ApiResult apiResult) throws IOException {
    String ret = GsonUtils.getGson(false, DateFormatUtils.ISO_DATE_FORMAT).toJson(apiResult);
    LOGGER.info("{}", ret);
    resp.setContentType("application/json;charset=utf-8");
    PrintWriter writer = resp.getWriter();
    writer.println(ret);
    writer.flush();
  }

  public static void forward(ServletRequest req, ServletResponse resp, String path)
      throws ServletException, IOException {
    req.getRequestDispatcher(buildPath(path)).forward(req, resp);
  }

  private static String buildPath(String path) {
    return VIEW_PATH + path + VIEW_SUFFIX;
  }
}
