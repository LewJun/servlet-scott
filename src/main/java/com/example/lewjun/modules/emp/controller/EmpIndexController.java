package com.example.lewjun.modules.emp.controller;

import com.example.lewjun.base.BaseController;
import com.example.lewjun.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 进入 Emp列表 界面
 *
 * @author huiye
 */
@WebServlet("/api/emp/index")
public class EmpIndexController extends BaseController {
  private static final long serialVersionUID = -7115223267378371581L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ServletUtils.forward(req, resp, "/emp/index");
  }
}
