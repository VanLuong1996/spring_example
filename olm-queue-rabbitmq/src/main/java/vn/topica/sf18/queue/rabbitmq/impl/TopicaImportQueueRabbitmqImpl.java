package vn.topica.sf18.queue.rabbitmq.impl;

import javax.annotation.PostConstruct;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.topica.TopicaImport;
import vn.topica.sf18.queue.TopicaImportQueue;

@Service
public class TopicaImportQueueRabbitmqImpl extends MyQueueRabbitmqImpl<TopicaImport> implements
    TopicaImportQueue {

  @Value("${app.queue.import}")
  private String queueName;

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @PostConstruct
  public void postConstructor() {
    super.queueName = queueName;
    super.rabbitTemplate = rabbitTemplate;
  }
}
