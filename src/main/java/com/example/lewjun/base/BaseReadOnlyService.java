package com.example.lewjun.base;

import java.util.Collection;

/** @author huiye */
public interface BaseReadOnlyService<T extends BaseModel<PK>, PK> {
  /**
   * 判断pk是否存在
   *
   * @param pk 主键
   * @return true如果存在
   */
  default boolean contains(PK pk) {
    throw new RuntimeException("un implemented");
  }

  /**
   * 根据pk查找
   *
   * @param pk 主键
   * @return T
   */
  default T get(PK pk) {
    throw new RuntimeException("un implemented");
  }

  /**
   * 查找所有
   *
   * @return 集合
   */
  default Collection<T> getAll() {
    throw new RuntimeException("un implemented");
  }
}
