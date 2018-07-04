package vn.topica.sf18.service.topica;

import vn.topica.sf18.constant.FileImportStatus;
import vn.topica.sf18.constant.FileImportType;
import vn.topica.sf18.model.topica.TopicaImport;

import java.util.List;

public interface TopicaImportService {

  TopicaImport save(TopicaImport baseObject);

  //region admin-on-rest
  List<TopicaImport> findByIds(Long[] ids);

  List<TopicaImport> filter(String search, Long userId, int pageIndex, int pageSize);

  TopicaImport getImportFileInfo(Long fileId);

  //import file
  TopicaImport importFile(String path, String url, FileImportType fileImportType);

  //xem trang thai cua viec import
  FileImportStatus getFileImportStatus(Long fileId);

  //update lai du lieu import
  TopicaImport updateImportedFile(Long fileId, String path, String url);

  //manager xac nhan (confirm) thay doi du lieu
  TopicaImport confirmChangedData(Long id, Long managerId);

}
