package vn.topica.sf18.service.impl.topica;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.topica.sf18.constant.FileImportStatus;
import vn.topica.sf18.constant.FileImportType;
import vn.topica.sf18.model.topica.TopicaImport;
import vn.topica.sf18.repository.topica.TopicaImportRepository;
import vn.topica.sf18.service.topica.TopicaImportService;

@Service
@Slf4j
public class TopicaImportServiceImpl implements TopicaImportService {

  @Autowired
  private TopicaImportRepository topicaImportRepository;

  @Override
  public TopicaImport getImportFileInfo(Long fileId) {
    return null;
  }

  @Override
  public TopicaImport importFile(String path, String url, FileImportType fileImportType) {
    return null;
  }

  @Override
  public FileImportStatus getFileImportStatus(Long fileId) {
    return null;
  }

  @Override
  public TopicaImport updateImportedFile(Long fileId, String path, String url) {
    return null;
  }

  @Override
  public TopicaImport confirmChangedData(Long id, Long managerId) {
    return null;
  }

  @Override
  public TopicaImport save(TopicaImport baseObject) {
    log.info("(save) {}", baseObject);
    return topicaImportRepository.save(baseObject);
  }

  @Override
  public Iterable<TopicaImport> findByIds(Iterable<Long> longs) {
    return null;
  }

  @Override
  public List<TopicaImport> filter(String search, Long userId, int pageIndex, int pageSize) {
    return null;
  }
}
