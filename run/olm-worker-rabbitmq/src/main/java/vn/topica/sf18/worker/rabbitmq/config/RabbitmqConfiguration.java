package vn.topica.sf18.worker.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfiguration {

  @Value("${app.queue.campaign}")
  private String queueCampaign;

  @Value("${app.queue.import}")
  private String queueImport;

  @Value("${rabbitmq.message.ttl}")
  private int messageTtl;

  @Value("${rabbitmq.concurrent.consumers}")
  private int concurrentConsumers;

  @Value("${rabbitmq.max.concurrent.consumers}")
  private int maxConcurrentConsumers;

  @Bean
  public Queue queueCampaign() {
    return new Queue(queueCampaign);
  }

  @Bean
  public Queue queueImport() {
    return new Queue(queueImport, true, false, false);
  }

  @Bean
  public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
      ConnectionFactory connectionFactory) {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    factory.setConcurrentConsumers(concurrentConsumers);
    factory.setMaxConcurrentConsumers(maxConcurrentConsumers);
    factory.setConnectionFactory(connectionFactory);
    factory.setMessageConverter(new Jackson2JsonMessageConverter());

    return factory;
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    RabbitTemplate template = new RabbitTemplate(connectionFactory);
    template.setMessageConverter(new Jackson2JsonMessageConverter());
    return template;
  }

}
