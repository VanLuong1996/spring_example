package vn.topica.sf18.queue.rabbitmq.impl;

import java.util.List;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import vn.topica.sf18.queue.MyQueue;

public class MyQueueRabbitmqImpl<T> implements MyQueue<T> {

  protected String queueName;

  protected RabbitTemplate rabbitTemplate;

  @Override
  public void push(T message) {
    rabbitTemplate.convertAndSend(queueName, message);
  }

  @Override
  public void push(List<T> messages) {
    for (T message : messages) {
      push(message);
    }
  }
}
