package vn.topica.sf18.service;

import java.util.List;

public interface BaseService<T> {

  T save(T baseObject);

  //region admin-on-rest
  List<T> findByIds(Long[] ids);

  List<T> filter(String search, Long userId, int pageIndex, int pageSize);
}
