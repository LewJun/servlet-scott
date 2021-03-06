package com.example.lewjun.modules.user.controller;

import com.example.lewjun.base.BaseController;
import com.example.lewjun.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 退出
 *
 * @author huiye
 */
@WebServlet("/api/user/logout")
public class UserLogoutController extends BaseController {
  private static final long serialVersionUID = -1667693488908540242L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    session.removeAttribute("loginUser");
    session.invalidate();
    ServletUtils.forward("/user/login");
  }
}
