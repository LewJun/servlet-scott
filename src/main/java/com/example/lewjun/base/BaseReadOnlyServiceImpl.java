package com.example.lewjun.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/** @author huiye */
public abstract class BaseReadOnlyServiceImpl<T extends BaseModel<PK>, PK>
    implements BaseReadOnlyService<T, PK> {
  protected static final Logger LOGGER = LoggerFactory.getLogger(BaseReadOnlyServiceImpl.class);
  BaseRepository<T, PK> repository;

  BaseReadOnlyServiceImpl() {
    // 初始化repository
    repository = setRepository();
  }

  /**
   * 初始化repository
   *
   * @return Repository
   */
  protected abstract BaseRepository<T, PK> setRepository();

  @Override
  public boolean contains(PK pk) {
    return repository.contains(pk);
  }

  @Override
  public T get(PK pk) {
    return repository.get(pk);
  }

  @Override
  public Collection<T> getAll() {
    return repository.getAll();
  }
}
