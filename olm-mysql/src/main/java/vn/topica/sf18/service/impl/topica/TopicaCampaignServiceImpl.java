package vn.topica.sf18.service.impl.topica;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.topica.TopicaCampaign;
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
  public List<TopicaCampaign> findByIds(Long[] ids) {
    return null;
  }

  @Override
  public List<TopicaCampaign> filter(String search, Long userId, int pageIndex, int pageSize) {
    return null;
  }
}
