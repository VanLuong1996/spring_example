package vn.topica.sf18.sql.service.impl.topica;

import java.util.List;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.topica.sf18.generic.specification.GenericSpecificationsBuilder;
import vn.topica.sf18.generic.specification.SearchCriteria;
import vn.topica.sf18.model.topica.TopicaCampaign;
import vn.topica.sf18.model.topica.dm4c.TopicaActivity;
import vn.topica.sf18.model.topica.dm4c.TopicaEstimator;
import vn.topica.sf18.model.topica.dm4c.TopicaLegal;
import vn.topica.sf18.model.topica.dm4c.TopicaProduct;
import vn.topica.sf18.service.topica.TopicaCampaignService;
import vn.topica.sf18.sql.repository.topica.TopicaCampaignRepository;
import vn.topica.sf18.sql.specification.BaseSpecification;

@AllArgsConstructor
@Service
@Slf4j
public class TopicaCampaignServiceImpl implements TopicaCampaignService {

  @Autowired
  private TopicaCampaignRepository topicaCampaignRepository;

  @Override
  public TopicaCampaign save(TopicaCampaign object) {
    return topicaCampaignRepository.save(object);
  }

  @Override
  public TopicaCampaign findById(Long id) {
    return topicaCampaignRepository.findOne(id);
  }

  @Override
  public Iterable<TopicaCampaign> findByIds(Iterable<Long> ids) {
    return topicaCampaignRepository.findByIds(ids);
  }

  @Override
  public List<TopicaCampaign> filter(String search, String username, int pageIndex, int pageSize) {
    GenericSpecificationsBuilder<TopicaCampaign> builder = new GenericSpecificationsBuilder<>();
    Function<SearchCriteria, Specification<TopicaCampaign>> converter = BaseSpecification::new;
    Specification<TopicaCampaign> spec = builder.build(converter, search);
    return topicaCampaignRepository.findAll(spec, new PageRequest(pageIndex - 1, pageSize)).getContent();
  }
}
