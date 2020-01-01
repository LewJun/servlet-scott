package com.example.lewjun.modules.emp.dao;

import com.example.lewjun.base.BaseRepository;
import com.example.lewjun.modules.emp.model.Emp;

import java.util.Collection;

/** @author huiye */
public interface EmpRepository extends BaseRepository<Emp, Integer> {
  /**
   * 根据名称查找
   *
   * @param name 名称
   * @return 找到返回true
   */
  boolean containsName(String name);

  /**
   * 根据名称查找
   *
   * @param name 名称
   * @return 符合条件的集合
   */
  Collection<Emp> findByName(String name);
}
