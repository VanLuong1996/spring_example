package vn.topica.sf18.sql.service.impl.topica;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.topica.TopicaCampaignData;
import vn.topica.sf18.service.topica.TopicaCampaignDataService;

@Service
@Slf4j
public class TopicaCampaignDataServiceImpl implements TopicaCampaignDataService {

  @Override
  public TopicaCampaignData save(TopicaCampaignData object) {
    return null;
  }

  @Override
  public TopicaCampaignData findById(Long aLong) {
    return null;
  }

  @Override
  public Iterable<TopicaCampaignData> findByIds(Iterable<Long> longs) {
    return null;
  }

  @Override
  public List<TopicaCampaignData> filter(String search, String username, int pageIndex,
      int pageSize) {
    return null;
  }
}
