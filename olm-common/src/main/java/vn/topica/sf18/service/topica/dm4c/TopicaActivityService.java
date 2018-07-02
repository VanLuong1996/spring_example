package vn.topica.sf18.service.topica.dm4c;

import vn.topica.sf18.model.topica.dm4c.TopicaActivity;

import java.util.List;

public interface TopicaActivityService {

    TopicaActivity save(TopicaActivity baseObject);

    //region admin-on-rest
    List<TopicaActivity> findByIds(Long[] ids);

    List<TopicaActivity> filter(String search, Long userId, int pageIndex, int pageSize);
}
