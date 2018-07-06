package vn.topica.sf18.worker.rabbitmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.topica.TopicaCampaign;

@Service
@Slf4j
public class TopicaCampaignListener {

  @RabbitListener(queues = "${app.queue.campaign}")
  public void handle(TopicaCampaign message) {
    log.info("Get message {}", message);
  }
}
