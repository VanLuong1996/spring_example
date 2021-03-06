package vn.topica.sf18.queue.redis.config;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("vn.topica.sf18.queue.redis.impl")
@Slf4j
public class ModuleConfiguration {

  @PostConstruct
  public void init() {
    log.info("init vn.topica.sf18.queue.redis.config success");
  }
}
