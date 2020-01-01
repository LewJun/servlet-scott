package com.example.lewjun.base;

import java.io.Serializable;

/** @author huiye */
public abstract class BaseModel<T> implements Serializable {
  private static final long serialVersionUID = 4570303070892228190L;
  private T id;

  protected BaseModel() {}

  public BaseModel(T id) {
    this();
    this.id = id;
  }

  public T getId() {
    return id;
  }

  public void setId(T id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "BaseModel{" + "id=" + id + '}';
  }
}
