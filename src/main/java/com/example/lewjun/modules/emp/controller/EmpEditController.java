package com.example.lewjun.modules.emp.controller;

import com.example.lewjun.base.BaseController;
import com.example.lewjun.modules.emp.model.Emp;
import com.example.lewjun.modules.emp.service.EmpService;
import com.example.lewjun.modules.emp.service.EmpServiceImpl;
import com.example.lewjun.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/api/emp/edit")
public class EmpEditController extends BaseController {
  private static final long serialVersionUID = -3246158044244262948L;
  private final EmpService empService;

  public EmpEditController() {
    empService = new EmpServiceImpl();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setAttribute("id", req.getParameter("id"));
    ServletUtils.forward(req, resp, "/emp/edit");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id"));
    Emp emp = new Emp();
    emp.setId(id);
    emp.setEname(req.getParameter("ename"));
    emp.setJob(req.getParameter("job"));
    emp.setMgr(Integer.valueOf(req.getParameter("mgr")));
    try {
      emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("hiredate")));
    } catch (ParseException e) {
      LOGGER.error("error", e);
    }
    emp.setDeptno(Integer.valueOf(req.getParameter("deptno")));
    empService.update(emp);

    ServletUtils.toJson(resp);
  }
}
