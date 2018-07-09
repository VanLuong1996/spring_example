package vn.topica.sf18.worker.redis.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.topica.TopicaCampaign;
import vn.topica.sf18.service.CommonService;
import vn.topica.sf18.service.topica.TopicaCampaignService;

@Service
@Slf4j
public class TopicaCampaignReceiver {

  @Autowired
  private CommonService commonService;

  public void receiveMessage(Object object) {
    TopicaCampaign campaign = (TopicaCampaign) object;

    log.info("Process campaign {}", campaign);
    commonService.processCampaign(campaign);
  }
}
