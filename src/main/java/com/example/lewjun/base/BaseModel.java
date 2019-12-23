package com.example.lewjun.base;

public abstract class BaseModel<T> {
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
