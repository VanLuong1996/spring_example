package vn.topica.sf18.service;

import java.util.List;

public interface BaseService<T, ID> {

  T save(T baseObject);

  //region admin-on-rest
  Iterable<T> findByIds(Iterable<ID> ids);

  List<T> filter(String search, Long userId, int pageIndex, int pageSize);
}
