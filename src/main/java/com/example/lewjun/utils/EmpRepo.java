package com.example.lewjun.utils;

import com.example.lewjun.modules.emp.model.Emp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Emp数据仓库
 *
 * @author huiye
 */
public class EmpRepo {
  public static final List<Emp> LIST = new ArrayList<>(11);

  static {
    try {
      LIST.addAll(
          Arrays.asList(
              new Emp(
                  7499,
                  "ALLEN",
                  "SALESMAN",
                  7698,
                  new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-20"),
                  30),
              new Emp(
                  7521,
                  "WARD",
                  "SALESMAN",
                  7698,
                  new SimpleDateFormat("yyyy-MM-dd").parse("1981-02-22"),
                  30),
              new Emp(
                  7566,
                  "JONES",
                  "MANAGER",
                  7839,
                  new SimpleDateFormat("yyyy-MM-dd").parse("1981-04-02"),
                  20),
              new Emp(
                  7654,
                  "MARTIN",
                  "SALESMAN",
                  7698,
                  new SimpleDateFormat("yyyy-MM-dd").parse("1981-09-28"),
                  30),
              new Emp(
                  7698,
                  "BLAKE",
                  "MANAGER",
                  7839,
                  new SimpleDateFormat("yyyy-MM-dd").parse("1981-05-01"),
                  30),
              new Emp(
                  7782,
                  "CLARK",
                  "MANAGER",
                  7839,
                  new SimpleDateFormat("yyyy-MM-dd").parse("1981-06-09"),
                  10),
              new Emp(
                  7839,
                  "KING",
                  "PRESIDENT",
                  0,
                  new SimpleDateFormat("yyyy-MM-dd").parse("1981-11-17"),
                  10),
              new Emp(
                  7844,
                  "TURNER",
                  "SALESMAN",
                  7698,
                  new SimpleDateFormat("yyyy-MM-dd").parse("1981-09-08"),
                  30),
              new Emp(
                  7900,
                  "JAMES",
                  "CLERK",
                  7698,
                  new SimpleDateFormat("yyyy-MM-dd").parse("1981-12-03"),
                  30),
              new Emp(
                  7902,
                  "FORD",
                  "ANALYST",
                  7566,
                  new SimpleDateFormat("yyyy-MM-dd").parse("1981-12-03"),
                  20),
              new Emp(
                  7934,
                  "MILLER",
                  "CLERK",
                  7782,
                  new SimpleDateFormat("yyyy-MM-dd").parse("1982-01-23"),
                  10)));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
