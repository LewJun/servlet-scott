package com.example.lewjun.utils;

import com.example.lewjun.base.ApiResult;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletUtils {
  private static final Logger LOGGER = LoggerFactory.getLogger(ServletUtils.class);

  private static final String VIEW_PATH = "/WEB-INF/jsp/";
  private static final String VIEW_SUFFIX = ".jsp";

  public static void toJson(HttpServletResponse resp) throws IOException {
    toJson(resp, new ApiResult<>());
  }

  public static void toJson(HttpServletResponse resp, ApiResult<Object> apiResult)
      throws IOException {
    String ret = GsonUtils.getGson(false, DateFormatUtils.ISO_DATE_FORMAT).toJson(apiResult);
    LOGGER.info("{}", ret);
    resp.setContentType("application/json;charset=utf-8");
    PrintWriter writer = resp.getWriter();
    writer.println(ret);
    writer.flush();
  }

  public static void forward(HttpServletRequest req, HttpServletResponse resp, String path)
      throws ServletException, IOException {
    req.getRequestDispatcher(buildPath(path)).forward(req, resp);
  }

  private static String buildPath(String path) {
    return VIEW_PATH + path + VIEW_SUFFIX;
  }
}
