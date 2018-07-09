package vn.topica.sf18.service;

import java.util.List;

public interface BaseService<T, ID> {

  T save(T object);

  T findById(ID id);

  //region admin-on-rest
  Iterable<T> findByIds(Iterable<ID> ids);

  List<T> filter(String search, String username, int pageIndex, int pageSize);
}
