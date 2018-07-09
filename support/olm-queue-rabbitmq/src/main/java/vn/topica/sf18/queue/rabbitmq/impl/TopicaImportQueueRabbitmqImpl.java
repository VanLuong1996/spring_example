package vn.topica.sf18.queue.rabbitmq.impl;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.topica.TopicaImport;
import vn.topica.sf18.queue.TopicaImportQueue;

@Service("TopicaImportQueue")
public class TopicaImportQueueRabbitmqImpl implements TopicaImportQueue {

  @Value("${app.queue.import}")
  private String queueName;

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Override
  public void push(TopicaImport message) {
    rabbitTemplate.convertAndSend(queueName, message);
  }

  @Override
  public void push(List<TopicaImport> messages) {
    for(TopicaImport topicaImport: messages){
      push(topicaImport);
    }
  }
}
