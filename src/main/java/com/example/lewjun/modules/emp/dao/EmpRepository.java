package com.example.lewjun.modules.emp.dao;

import com.example.lewjun.base.Repository;
import com.example.lewjun.modules.emp.model.Emp;

import java.util.Collection;

/** @author huiye */
public interface EmpRepository extends Repository<Emp, Integer> {
  boolean containsName(String name);

  /**
   * 根据名字查找
   *
   * @param name 名字
   * @return
   */
  Collection<Emp> findByName(String name);
}
