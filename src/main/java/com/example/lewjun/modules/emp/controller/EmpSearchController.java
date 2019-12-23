package com.example.lewjun.modules.emp.controller;

import com.example.lewjun.base.ApiResult;
import com.example.lewjun.base.BaseController;
import com.example.lewjun.modules.emp.model.Emp;
import com.example.lewjun.modules.emp.service.EmpService;
import com.example.lewjun.modules.emp.service.EmpServiceImpl;
import com.example.lewjun.utils.ServletUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/** 查询Scott */
@WebServlet("/api/emp/search")
public class EmpSearchController extends BaseController {
  private static final long serialVersionUID = -7115223267378371581L;

  private final EmpService empService;

  public EmpSearchController() {
    empService = new EmpServiceImpl();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String keywords = req.getParameter("keywords");
    LOGGER.info("keywords = {}", keywords);
    Collection<Emp> empCollection;
    if (StringUtils.isBlank(keywords)) empCollection = empService.getAll();
    else
        empCollection = empService.findByName(keywords);

    ServletUtils.toJson(resp, new ApiResult<>(empCollection));
  }
}
