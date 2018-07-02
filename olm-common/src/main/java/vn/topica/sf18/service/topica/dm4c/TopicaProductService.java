package vn.topica.sf18.service.topica.dm4c;

import vn.topica.sf18.model.topica.dm4c.TopicaProduct;

import java.util.List;

public interface TopicaProductService {

    TopicaProduct save(TopicaProduct baseObject);

    //region admin-on-rest
    List<TopicaProduct> findByIds(Long[] ids);

    List<TopicaProduct> filter(String search, Long userId, int pageIndex, int pageSize);
}
