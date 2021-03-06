package vn.topica.sf18.sql.config;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("vn.topica.sf18.sql.service")
@EnableJpaRepositories("vn.topica.sf18.sql.repository")
@Slf4j
public class ModuleConfiguration {

  @PostConstruct
  public void init() {
    log.info("init vn.topica.sf18.sql.config success");
  }
}
