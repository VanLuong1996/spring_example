package vn.topica.sf18.queue.rabbitmq.impl;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.topica.TopicaCampaign;
import vn.topica.sf18.queue.TopicaCampaignQueue;

@Service
public class TopicaCampaignQueueRabbitmqImpl implements TopicaCampaignQueue {

  @Value("${app.queue.campaign}")
  private String queueName;

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Override
  public void push(TopicaCampaign message) {
    rabbitTemplate.convertAndSend(queueName, message);
  }

  @Override
  public void push(List<TopicaCampaign> messages) {
    for(TopicaCampaign topicaImport: messages){
      push(topicaImport);
    }
  }
}
