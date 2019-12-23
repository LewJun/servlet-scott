package com.example.lewjun.modules.emp.dao;

import com.example.lewjun.base.Repository;
import com.example.lewjun.modules.emp.model.Emp;

import java.util.Collection;

public interface EmpRepository extends Repository<Emp, Integer> {
  boolean containsName(String name);

  Collection<Emp> findByName(String name);
}
