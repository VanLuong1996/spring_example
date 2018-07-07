package vn.topica.sf18.api.config;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ModuleConfiguration {

  @PostConstruct
  public void init() {
    log.info("init configuration success");
  }
}
