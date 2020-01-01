package com.example.lewjun.base;

import java.util.Collection;

/** @author huiye */
public interface BaseReadOnlyService<T extends BaseModel, PK> {
  default boolean contains(PK pk) {
    throw new RuntimeException("un implemented");
  }

  default T get(PK pk) {
    throw new RuntimeException("un implemented");
  }

  default Collection<T> getAll() {
    throw new RuntimeException("un implemented");
  }
}
