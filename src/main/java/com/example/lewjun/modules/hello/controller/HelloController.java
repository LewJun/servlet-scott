package com.example.lewjun.modules.hello.controller;

import com.example.lewjun.base.BaseController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 使用WebServlet声明该类是一个Servlet
@WebServlet("/hello")
public class HelloController extends BaseController {
  private static final long serialVersionUID = 2656225472432421109L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    LOGGER.info("【now = {}】", now);
    // 往req中存放数据
    req.setAttribute("now", now);

    // 跳转到指定文件
    req.getRequestDispatcher("/WEB-INF/jsp/hello/index.jsp").forward(req, resp);
  }
}
