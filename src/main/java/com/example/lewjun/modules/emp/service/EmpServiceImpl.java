package com.example.lewjun.modules.emp.service;

import com.example.lewjun.modules.emp.dao.EmpRepository;
import com.example.lewjun.modules.emp.dao.InMemEmpRepository;
import com.example.lewjun.modules.emp.model.Emp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class EmpServiceImpl implements EmpService {
  private static final Logger LOGGER = LoggerFactory.getLogger(EmpServiceImpl.class);
  private final EmpRepository empRepository;

  public EmpServiceImpl() {
    empRepository = new InMemEmpRepository();
  }

  @Override
  public void add(Emp t) {
    empRepository.add(t);
  }

  @Override
  public void delete(Integer pk) {
    empRepository.remove(pk);
  }

  @Override
  public Emp findById(Integer pk) {
    return empRepository.get(pk);
  }

  @Override
  public Collection<Emp> findByName(String name) {
    return empRepository.findByName(name);
  }

  @Override
  public Collection<Emp> getAll() {
    LOGGER.info("empRepository={}", empRepository);
    return empRepository.getAll();
  }

  @Override
  public void update(Emp t) {
    empRepository.update(t);
  }
}
