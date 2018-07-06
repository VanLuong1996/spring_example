package vn.topica.sf18.worker.redis.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.topica.TopicaCampaign;

@Service
@Slf4j
public class TopicaCampaignReceiver {

  public void receiveMessage(Object object) {
    TopicaCampaign topicaImport = (TopicaCampaign) object;
  }
}
