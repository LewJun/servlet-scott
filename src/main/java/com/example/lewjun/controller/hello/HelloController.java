package com.example.lewjun.controller.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 使用WebServlet声明该类是一个Servlet
@WebServlet("/hello")
public class HelloController extends HttpServlet {
    private static final long serialVersionUID = 2656225472432421109L;

    // 重写doGet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 往req中存放数据
        req.setAttribute("now", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        // 跳转到指定文件
        req.getRequestDispatcher("/WEB-INF/jsp/hello/index.jsp").forward(req, resp);
    }
}
