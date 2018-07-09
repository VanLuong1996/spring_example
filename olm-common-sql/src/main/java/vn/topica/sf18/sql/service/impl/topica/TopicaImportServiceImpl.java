package vn.topica.sf18.sql.service.impl.topica;

import java.util.List;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import net.friend.common.spring.boot.generic.specification.GenericSpecificationsBuilder;
import net.friend.common.spring.boot.generic.specification.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.topica.sf18.constant.FileImportStatus;
import vn.topica.sf18.constant.FileImportType;
import vn.topica.sf18.model.topica.TopicaImport;
import vn.topica.sf18.sql.repository.topica.TopicaImportRepository;
import vn.topica.sf18.service.topica.TopicaImportService;
import vn.topica.sf18.sql.specification.BaseSpecification;

@Service
@Slf4j
public class TopicaImportServiceImpl implements TopicaImportService {

  @Autowired
  private TopicaImportRepository topicaImportRepository;

  @Override
  public TopicaImport save(TopicaImport baseObject) {
    return topicaImportRepository.save(baseObject);
  }

  @Override
  public TopicaImport findById(Long id) {
    return topicaImportRepository.findOne(id);
  }

  @Override
  public Iterable<TopicaImport> findByIds(Iterable<Long> ids) {
    return topicaImportRepository.findByIds(ids);
  }

  @Override
  public List<TopicaImport> filter(String search, String username, int pageIndex, int pageSize) {
    GenericSpecificationsBuilder<TopicaImport> builder = new GenericSpecificationsBuilder<>();
    Function<SearchCriteria, Specification<TopicaImport>> converter = BaseSpecification::new;
    Specification<TopicaImport> spec = builder.build(converter, search);
    return topicaImportRepository.findAll(spec, new PageRequest(pageIndex - 1, pageSize)).getContent();
  }

  @Override
  public int updatePath(long id, String path) {
    return topicaImportRepository.updatePath(id, path);
  }

  @Override
  public int updateStatus(long id, FileImportStatus status) {
    return topicaImportRepository.updateStatus(id, status);
  }
}
