package vn.topica.sf18.service.topica.dm4c;

import vn.topica.sf18.model.topica.dm4c.TopicaLegal;

import java.util.List;

public interface TopicaLegalService {

    TopicaLegal save(TopicaLegal baseObject);

    //region admin-on-rest
    List<TopicaLegal> findByIds(Long[] ids);

    List<TopicaLegal> filter(String search, Long userId, int pageIndex, int pageSize);
}
