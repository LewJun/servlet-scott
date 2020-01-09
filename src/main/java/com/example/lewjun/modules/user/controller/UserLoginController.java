package com.example.lewjun.modules.user.controller;

import com.example.lewjun.base.BaseController;
import com.example.lewjun.base.EnumApiResultCode;
import com.example.lewjun.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录
 *
 * @author huiye
 */
@WebServlet("/api/user/login")
public class UserLoginController extends BaseController {
  private static final long serialVersionUID = -1667693488908540242L;

  /**
   * 跳转到登录界面
   *
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ServletUtils.forward("user/login");
  }

  /**
   * 登录
   *
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    // 验证通过后创建session，并在session中放入相关信息
    if ("admin".equals(username) && "123456".equals(password)) {
      HttpSession session = req.getSession();
      session.setAttribute("loginUser", username);
      ServletUtils.success();
    } else {
      ServletUtils.failure(EnumApiResultCode.USER_LOGIN_FAIL);
    }
  }
}
