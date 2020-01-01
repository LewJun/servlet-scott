package com.example.lewjun.modules.emp.model;

import com.example.lewjun.base.BaseModel;

import java.io.Serializable;
import java.util.Date;

/** @author huiye */
public class Emp extends BaseModel<Integer> implements Serializable {
  private static final long serialVersionUID = -313826846973561454L;

  private String ename;

  private String job;

  private Integer mgr;

  private Date hiredate;

  private Integer deptno;

  public Emp() {}

  public Emp(Integer id, String ename, String job, Integer mgr, Date hiredate, Integer deptno) {
    super(id);
    this.ename = ename;
    this.job = job;
    this.mgr = mgr;
    this.hiredate = hiredate;
    this.deptno = deptno;
  }

  public String getEname() {
    return ename;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public Integer getMgr() {
    return mgr;
  }

  public void setMgr(Integer mgr) {
    this.mgr = mgr;
  }

  public Date getHiredate() {
    return hiredate;
  }

  public void setHiredate(Date hiredate) {
    this.hiredate = hiredate;
  }

  public Integer getDeptno() {
    return deptno;
  }

  public void setDeptno(Integer deptno) {
    this.deptno = deptno;
  }

  @Override
  public String toString() {
    return "Emp{"
        + "ename='"
        + ename
        + '\''
        + ", job='"
        + job
        + '\''
        + ", mgr="
        + mgr
        + ", hiredate="
        + hiredate
        + ", deptno="
        + deptno
        + "} "
        + super.toString();
  }
}
