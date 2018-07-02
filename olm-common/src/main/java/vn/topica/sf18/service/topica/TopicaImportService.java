package vn.topica.sf18.service.topica;

import vn.topica.sf18.model.topica.TopicaImport;

import java.util.List;

public interface TopicaImportService {

    TopicaImport save(TopicaImport baseObject);

    //region admin-on-rest
    List<TopicaImport> findByIds(Long[] ids);

    List<TopicaImport> filter(String search, Long userId, int pageIndex, int pageSize);
}
