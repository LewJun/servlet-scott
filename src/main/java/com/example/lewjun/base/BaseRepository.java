package com.example.lewjun.base;

import java.util.List;

/** @author huiye */
public interface BaseRepository<T extends BaseModel, PK> extends BaseReadOnlyRepository<T, PK> {
  void add(T t);

  void add(T... ts);

  void add(List<T> ts);

  void remove(PK pk);

  void remove(PK... pks);

  void remove(List<PK> pks);

  void update(T t);
}
