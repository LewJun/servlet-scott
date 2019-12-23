package com.example.lewjun.base;

import java.util.List;

public interface Repository<T extends BaseModel, PK> extends ReadOnlyRepository<T, PK> {
  void add(T t);

  void add(T... ts);

  void add(List<T> ts);

  void remove(PK pk);

  void remove(PK... pks);

  void remove(List<PK> pks);

  void update(T t);
}
