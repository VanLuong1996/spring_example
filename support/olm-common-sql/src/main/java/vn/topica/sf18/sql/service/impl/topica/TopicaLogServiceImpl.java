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
import vn.topica.sf18.model.topica.TopicaLog;
import vn.topica.sf18.service.topica.TopicaLogService;
import vn.topica.sf18.sql.repository.topica.TopicaLogRepository;
import vn.topica.sf18.sql.specification.BaseSpecification;

@Service
@Slf4j
public class TopicaLogServiceImpl implements TopicaLogService {

  @Autowired
  private TopicaLogRepository topicaLogRepository;

  @Override
  public TopicaLog save(TopicaLog baseObject) {
    return topicaLogRepository.save(baseObject);
  }

  @Override
  public TopicaLog findById(Long id) {
    return topicaLogRepository.findOne(id);
  }

  @Override
  public Iterable<TopicaLog> findByIds(Iterable<Long> ids) {
    return topicaLogRepository.findByIds(ids);
  }

  @Override
  public List<TopicaLog> filter(String search, String username, int pageIndex, int pageSize) {
    GenericSpecificationsBuilder<TopicaLog> builder = new GenericSpecificationsBuilder<>();
    Function<SearchCriteria, Specification<TopicaLog>> converter = BaseSpecification::new;
    Specification<TopicaLog> spec = builder.build(converter, search);
    return topicaLogRepository.findAll(spec, new PageRequest(pageIndex - 1, pageSize)).getContent();
  }
}
