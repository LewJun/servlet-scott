package com.example.lewjun.modules.emp.controller;

import com.example.lewjun.base.BaseController;
import com.example.lewjun.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/emp/detail")
public class EmpDetailController extends BaseController {
  private static final long serialVersionUID = -6617700568929916855L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setAttribute("id", req.getParameter("id"));
    ServletUtils.forward(req, resp, "/emp/detail");
  }
}
