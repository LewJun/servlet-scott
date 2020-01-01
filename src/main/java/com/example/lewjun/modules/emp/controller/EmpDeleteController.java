package com.example.lewjun.modules.emp.controller;

import com.example.lewjun.base.BaseController;
import com.example.lewjun.modules.emp.service.EmpService;
import com.example.lewjun.modules.emp.service.EmpServiceImpl;
import com.example.lewjun.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** @author huiye */
@WebServlet("/api/emp/delete")
public class EmpDeleteController extends BaseController {
  private static final long serialVersionUID = -682261820632786092L;

  private final EmpService empService;

  public EmpDeleteController() {
    empService = new EmpServiceImpl();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    empService.remove(Integer.valueOf(req.getParameter("id")));
    ServletUtils.success(resp);
  }
}
