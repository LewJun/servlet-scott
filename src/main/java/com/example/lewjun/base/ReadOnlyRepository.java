package com.example.lewjun.base;

import java.util.Collection;

public interface ReadOnlyRepository<T extends BaseModel, PK> {
  boolean contains(PK pk);

  T get(PK pk);

  Collection<T> getAll();
}
