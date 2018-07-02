package vn.topica.sf18.service.topica.dm4c;

import vn.topica.sf18.model.topica.dm4c.TopicaEstimator;

import java.util.List;

public interface TopicaEstimatorService {

    TopicaEstimator save(TopicaEstimator baseObject);

    //region admin-on-rest
    List<TopicaEstimator> findByIds(Long[] ids);

    List<TopicaEstimator> filter(String search, Long userId, int pageIndex, int pageSize);
}
