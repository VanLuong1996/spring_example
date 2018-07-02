package vn.topica.sf18.service.topica;

import vn.topica.sf18.model.topica.TopicaLog;

import java.util.List;

public interface TopicaLogService {

    TopicaLog save(TopicaLog baseObject);

    //region admin-on-rest
    List<TopicaLog> findByIds(Long[] ids);

    List<TopicaLog> filter(String search, Long userId, int pageIndex, int pageSize);
}
