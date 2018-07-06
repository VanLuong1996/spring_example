package vn.topica.sf18.queue.redis.impl;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import vn.topica.sf18.model.topica.TopicaCampaign;
import vn.topica.sf18.queue.TopicaCampaignQueue;

public class TopicaCampaignQueueRedisImpl extends MyQueueRedisImpl<TopicaCampaign> implements
    TopicaCampaignQueue {

  @Value("${app.queue.campaign}")
  private String queueName;

  @Autowired
  private RedisTemplate<String, Object> redisTemplate;

  @PostConstruct
  public void postConstructor() {
    super.queueName = queueName;
    super.redisTemplate = redisTemplate;
  }
}
