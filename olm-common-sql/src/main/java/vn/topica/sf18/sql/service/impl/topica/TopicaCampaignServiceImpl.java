package vn.topica.sf18.sql.service.impl.topica;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.topica.TopicaCampaign;
import vn.topica.sf18.model.topica.dm4c.TopicaActivity;
import vn.topica.sf18.model.topica.dm4c.TopicaEstimator;
import vn.topica.sf18.model.topica.dm4c.TopicaLegal;
import vn.topica.sf18.model.topica.dm4c.TopicaProduct;
import vn.topica.sf18.service.topica.TopicaCampaignService;

@AllArgsConstructor
@Service
@Slf4j
public class TopicaCampaignServiceImpl implements TopicaCampaignService {

  @Override
  public TopicaCampaign save(TopicaCampaign baseObject) {
    return null;
  }

  @Override
  public TopicaCampaign findById(Long id) {
    return null;
  }

  @Override
  public List<TopicaCampaign> findCampaignByImportId(Long fileId) {
    return null;
  }

  @Override
  public Iterable<TopicaCampaign> findByIds(Iterable<Long> ids) {
    return null;
  }

  @Override
  public List<TopicaCampaign> filter(String search, Long userId, int pageIndex, int pageSize) {
    return null;
  }

  @Override
  public List<TopicaCampaign> updateImportedFile(Long fileId) {
    return null;
  }

  @Override
  public TopicaCampaign mappingCampaignToStakeholders(Long campaignId, TopicaProduct topicaProduct,
      TopicaActivity topicaActivity, TopicaLegal legal, TopicaEstimator topicaEstimator) {
    return null;
  }

  @Override
  public void importCampaign(Long importId) {

  }
}
