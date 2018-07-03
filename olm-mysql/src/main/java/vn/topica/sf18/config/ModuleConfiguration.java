package vn.topica.sf18.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.topica.sf18.service.impl.topica.dm4c.TopicaActivityServiceImpl;
import vn.topica.sf18.service.topica.dm4c.TopicaActivityService;

@Configuration
public class ModuleConfiguration {

  @ConditionalOnMissingBean
  @Bean
  public TopicaActivityService activityService(){
    return new TopicaActivityServiceImpl();
  }
}
