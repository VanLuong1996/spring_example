package vn.topica.sf18.queue.rabbitmq.impl;

import javax.annotation.PostConstruct;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.topica.TopicaCampaign;
import vn.topica.sf18.queue.TopicaCampaignQueue;

@Service
public class TopicaCampaignQueueRabbitmqImpl extends MyQueueRabbitmqImpl<TopicaCampaign> implements
    TopicaCampaignQueue {

  @Value("${app.queue.campaign}")
  private String queueName;

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @PostConstruct
  public void postConstructor() {
    super.queueName = queueName;
    super.rabbitTemplate = rabbitTemplate;
  }
}
