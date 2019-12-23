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

@WebServlet("/api/emp/create")
public class EmpCreateController extends BaseController {
  private static final long serialVersionUID = -682261820632786092L;

  private final EmpService empService;

  public EmpCreateController() {
    empService = new EmpServiceImpl();
  }

  /** 进入创建界面 */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ServletUtils.forward(req, resp, "/emp/create");
  }

  /** 处理创建请求 */
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Emp emp = new Emp();
    emp.setId(Integer.valueOf(req.getParameter("id")));
    emp.setEname(req.getParameter("ename"));
    emp.setJob(req.getParameter("job"));
    emp.setMgr(Integer.valueOf(req.getParameter("mgr")));
    try {
      emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("hiredate")));
    } catch (ParseException e) {
      LOGGER.error("error", e);
    }
    emp.setDeptno(Integer.valueOf(req.getParameter("deptno")));
    empService.add(emp);

    ServletUtils.toJson(resp);
  }
}
