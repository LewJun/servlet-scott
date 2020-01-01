package com.example.lewjun.base;

import java.util.Arrays;
import java.util.List;

/** @author huiye */
public abstract class BaseServiceImpl<T extends BaseModel<PK>, PK>
    extends BaseReadOnlyServiceImpl<T, PK> implements BaseService<T, PK> {

  @Override
  public void update(T t) {
    repository.update(t);
  }

  @SafeVarargs
  @Override
  public final void add(T... ts) {
    add(Arrays.asList(ts));
  }

  @Override
  public void add(List<T> ts) {
    repository.add(ts);
  }

  @Override
  public void add(T t) {
    repository.add(t);
  }

  @Override
  public void remove(PK pk) {
    repository.remove(pk);
  }

  @SafeVarargs
  @Override
  public final void remove(PK... pks) {
    remove(Arrays.asList(pks));
  }

  @Override
  public void remove(List<PK> pks) {
    repository.remove(pks);
  }
}
