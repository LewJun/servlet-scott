package com.example.lewjun.base;

import java.util.List;

/** @author huiye */
public interface BaseRepository<T extends BaseModel<PK>, PK> extends BaseReadOnlyRepository<T, PK> {
  /**
   * 新增单个
   *
   * @param t 对象
   */
  default void add(T t) {}

  /**
   * 新增数组
   *
   * @param ts 对象数组
   */
  default void add(T... ts) {}

  /**
   * 新增集合
   *
   * @param ts 对象集合
   */
  default void add(List<T> ts) {}

  /**
   * 删除单个
   *
   * @param pk 主键
   */
  default void remove(PK pk) {}

  /**
   * 删除数组
   *
   * @param pks 主键数组
   */
  default void remove(PK... pks) {}

  /**
   * 删除集合
   *
   * @param pks 主键集合
   */
  default void remove(List<PK> pks) {}

  /**
   * 更新
   *
   * @param t 对象
   */
  default void update(T t) {}
}
