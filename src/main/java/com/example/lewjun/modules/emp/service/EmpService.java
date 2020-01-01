package com.example.lewjun.modules.emp.service;

import com.example.lewjun.base.BaseService;
import com.example.lewjun.modules.emp.model.Emp;

import java.util.Collection;

/** @author huiye */
public interface EmpService extends BaseService<Emp, Integer> {
  /**
   * 根据name查找
   *
   * @param name 名称
   * @return 符合条件的集合
   */
  Collection<Emp> findByName(String name);
}
