package com.example.lewjun.modules.emp.service;

import com.example.lewjun.base.BaseRepository;
import com.example.lewjun.base.BaseServiceImpl;
import com.example.lewjun.modules.emp.dao.EmpRepository;
import com.example.lewjun.modules.emp.dao.InMemEmpRepository;
import com.example.lewjun.modules.emp.model.Emp;

import java.util.Collection;

/** @author huiye */
public class EmpServiceImpl extends BaseServiceImpl<Emp, Integer> implements EmpService {

  private EmpRepository empRepository;

  @Override
  protected BaseRepository<Emp, Integer> setRepository() {
    empRepository = new InMemEmpRepository();
    return empRepository;
  }

  @Override
  public Collection<Emp> findByName(String name) {
    return empRepository.findByName(name);
  }
}
