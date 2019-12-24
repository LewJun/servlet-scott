package com.example.lewjun.test.emp;

import com.example.lewjun.modules.emp.model.Emp;
import com.example.lewjun.modules.emp.service.EmpService;
import com.example.lewjun.modules.emp.service.EmpServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Date;

public class EmpServiceImplTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(EmpServiceImplTest.class);

  private EmpService empService;

  @Before
  public void setUp() {
    empService = new EmpServiceImpl();
  }

  @After
  public void after() {
    empService = null;
  }

  @Test
  public void add() {
    empService.add(new Emp(9000, "abc", "dev", 7839, new Date(), 40));

    getAll();
  }

  @Test
  public void getAll() {
    Collection<Emp> emps = empService.getAll();
    LOGGER.info("{}", emps);
  }

  @Test
  public void delete() {
    empService.delete(7839);
  }

  @Test
  public void findById() {
    Emp emp = empService.findById(7839);
    LOGGER.info("{}", emp);
  }

  @Test
  public void findByName() {
    Collection<Emp> emps = empService.findByName("king");
    LOGGER.info("{}", emps);
  }

  @Test
  public void update() {
    Emp t = new Emp();
    t.setId(7839);
    t.setEname("LewJun");
    empService.update(t);

    getAll();
  }
}
