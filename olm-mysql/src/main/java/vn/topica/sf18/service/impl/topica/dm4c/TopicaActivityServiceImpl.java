package vn.topica.sf18.service.impl.topica.dm4c;

import java.util.List;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.friend.common.spring.boot.generic.specification.GenericSpecificationsBuilder;
import net.friend.common.spring.boot.generic.specification.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.topica.dm4c.TopicaActivity;
import vn.topica.sf18.repository.topica.dm4c.TopicaActivityRepository;
import vn.topica.sf18.service.topica.dm4c.TopicaActivityService;
import vn.topica.sf18.specification.BaseSpecification;

@AllArgsConstructor
@Service
@Slf4j
public class TopicaActivityServiceImpl implements TopicaActivityService {

  @Autowired
  private TopicaActivityRepository activityRepository;

  @Override
  public TopicaActivity save(TopicaActivity baseObject) {
    return activityRepository.save(baseObject);
  }

  @Override
  public List<TopicaActivity> findByIds(Long[] ids) {
    return activityRepository.findByIds(ids);
  }

  @Override
  public List<TopicaActivity> filter(String search, Long userId, int pageIndex, int pageSize) {
    GenericSpecificationsBuilder<TopicaActivity> builder = new GenericSpecificationsBuilder<>();
    Function<SearchCriteria, Specification<TopicaActivity>> converter = BaseSpecification::new;
    Specification<TopicaActivity> spec = builder.build(converter, search);
    return activityRepository.findAll(spec, new PageRequest(pageIndex - 1, pageSize))
        .getContent();
  }
}
