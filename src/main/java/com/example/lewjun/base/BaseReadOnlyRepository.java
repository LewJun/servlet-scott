package com.example.lewjun.base;

import java.util.Collection;

/** @author huiye */
public interface BaseReadOnlyRepository<T extends BaseModel, PK> {
  boolean contains(PK pk);

  T get(PK pk);

  Collection<T> getAll();
}
