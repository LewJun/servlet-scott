package com.example.lewjun.modules.emp.controller;

import com.example.lewjun.base.ApiResult;
import com.example.lewjun.base.BaseController;
import com.example.lewjun.modules.emp.service.EmpService;
import com.example.lewjun.modules.emp.service.EmpServiceImpl;
import com.example.lewjun.utils.ServletUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/emp/search/id")
public class EmpSearchByIdController extends BaseController {
  private static final long serialVersionUID = 7219237439797484774L;

  private final EmpService empService;

  public EmpSearchByIdController() {
    empService = new EmpServiceImpl();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    int id = Integer.parseInt(req.getParameter("id"));
    LOGGER.info("id = {}", id);
    ServletUtils.toJson(resp, new ApiResult<>(empService.findById(id)));
  }
}
