package vn.topica.sf18.service.topica;

import vn.topica.sf18.constant.FileImportStatus;
import vn.topica.sf18.model.topica.TopicaImport;
import vn.topica.sf18.service.BaseService;

public interface TopicaImportService extends BaseService<TopicaImport, Long> {

  int updatePath(long id, String path);

  int updateStatus(long id, FileImportStatus status);
}
