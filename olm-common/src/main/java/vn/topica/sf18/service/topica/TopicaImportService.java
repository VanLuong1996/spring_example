package vn.topica.sf18.service.topica;

import vn.topica.sf18.constant.FileImportStatus;
import vn.topica.sf18.constant.FileImportType;
import vn.topica.sf18.model.topica.TopicaImport;
import vn.topica.sf18.service.BaseService;

public interface TopicaImportService extends BaseService<TopicaImport, Long> {

  //get topicaimport by id
  TopicaImport findById(long id);

  //import file
  TopicaImport save(String path, FileImportType type);

  //update file
  void update(long id, String path);

  //confirm file
  void confirm(List<Long> ids);

}
