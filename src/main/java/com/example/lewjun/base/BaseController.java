package com.example.lewjun.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;

/** @author huiye */
public abstract class BaseController extends HttpServlet {

  protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
  private static final long serialVersionUID = 4038172173080385810L;
}
