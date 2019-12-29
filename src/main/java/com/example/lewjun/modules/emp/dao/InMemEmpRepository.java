package com.example.lewjun.modules.emp.dao;

import com.example.lewjun.modules.emp.model.Emp;
import com.example.lewjun.utils.EmpRepo;
import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/** @author huiye */
public class InMemEmpRepository implements EmpRepository {

  @Override
  public boolean containsName(String name) {
    return CollectionUtils.isNotEmpty(findByName(name));
  }

  @Override
  public Collection<Emp> findByName(String name) {
    return EmpRepo.LIST.stream()
        .filter(
            it -> {
              String enameLower = it.getEname().toLowerCase();
              String nameLower = name.toLowerCase();
              return enameLower.startsWith(nameLower) || enameLower.endsWith(nameLower);
            })
        .collect(Collectors.toList());
  }

  @Override
  public void add(Emp emp) {
    EmpRepo.LIST.add(emp);
  }

  @Override
  public void add(Emp... emps) {
    add(Arrays.asList(emps));
  }

  @Override
  public void add(List<Emp> emps) {
    EmpRepo.LIST.addAll(emps);
  }

  @Override
  public void remove(Integer pk) {
    EmpRepo.LIST.remove(get(pk));
  }

  @Override
  public void remove(Integer... pks) {
    remove(Arrays.asList(pks));
  }

  @Override
  public void remove(List<Integer> pks) {
    pks.forEach(it -> EmpRepo.LIST.remove(get(it)));
  }

  @Override
  public void update(Emp emp) {
    Integer id = emp.getId();
    if (contains(id)) {
      remove(id);
      add(emp);
    }
  }

  @Override
  public boolean contains(Integer pk) {
    return EmpRepo.LIST.stream().anyMatch(it -> it.getId().equals(pk));
  }

  @Override
  public Emp get(Integer pk) {
    for (Emp entity : EmpRepo.LIST) {
      if (entity.getId().equals(pk)) {
        return entity;
      }
    }
    return new Emp();
  }

  @Override
  public Collection<Emp> getAll() {
    return EmpRepo.LIST;
  }
}
