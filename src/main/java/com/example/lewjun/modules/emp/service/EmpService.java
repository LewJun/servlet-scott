package com.example.lewjun.modules.emp.service;

import com.example.lewjun.modules.emp.model.Emp;

import java.util.Collection;

public interface EmpService {
  void add(Emp t);

  void delete(Integer pk);

  void update(Emp t);

  Emp findById(Integer pk);

  Collection<Emp> findByName(String name);

  Collection<Emp> getAll();
}
