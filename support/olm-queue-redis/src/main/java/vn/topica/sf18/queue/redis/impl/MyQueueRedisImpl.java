package vn.topica.sf18.queue.redis.impl;

import java.util.List;
import org.springframework.data.redis.core.RedisTemplate;
import vn.topica.sf18.queue.MyQueue;

public class MyQueueRedisImpl<T> implements MyQueue<T> {

  protected String queueName;

  protected RedisTemplate<String, Object> redisTemplate;

  @Override
  public void push(T message) {
    redisTemplate.convertAndSend(queueName, message);
  }

  @Override
  public void push(List<T> messages) {
    for (T message : messages) {
      push(message);
    }
  }
}
