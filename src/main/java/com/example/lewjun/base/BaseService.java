package com.example.lewjun.base;

import java.util.List;

/** @author huiye */
public interface BaseService<T extends BaseModel, PK> extends BaseReadOnlyService<T, PK> {
  default void add(T t) {}

  default void add(T... ts) {}

  default void add(List<T> ts) {}

  default void remove(PK pk) {}

  default void remove(PK... pks) {}

  default void remove(List<PK> pks) {}

  default void update(T t) {}
}
