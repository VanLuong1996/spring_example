package vn.topica.sf18.worker.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import vn.topica.sf18.worker.redis.receiver.TopicaCampaignReceiver;
import vn.topica.sf18.worker.redis.receiver.TopicaImportReceiver;

@Configuration
public class RedisWorkerConfiguration {

  @Value("${app.queue.campaign}")
  private String queueCampaign;

  @Value("${app.queue.import}")
  private String queueImport;

  @Bean
  RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
      MessageListenerAdapter topicaCampaignListenerAdapter,
      MessageListenerAdapter topicaImportListenerAdapter) {
    RedisMessageListenerContainer container = new RedisMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.addMessageListener(topicaCampaignListenerAdapter,
        new PatternTopic(queueCampaign));
    container.addMessageListener(topicaImportListenerAdapter,
        new PatternTopic(queueImport));
    return container;
  }

  @Bean
  MessageListenerAdapter topicaCampaignListenerAdapter(TopicaCampaignReceiver receiver) {
    MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver,
        "receiveMessage");
    messageListenerAdapter.setSerializer(new JdkSerializationRedisSerializer());
    return messageListenerAdapter;
  }

  @Bean
  MessageListenerAdapter topicaImportListenerAdapter(TopicaImportReceiver receiver) {
    MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver,
        "receiveMessage");
    messageListenerAdapter.setSerializer(new JdkSerializationRedisSerializer());
    return messageListenerAdapter;
  }
}
