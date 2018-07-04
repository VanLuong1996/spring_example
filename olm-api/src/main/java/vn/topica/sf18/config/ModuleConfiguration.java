package vn.topica.sf18.config;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import vn.topica.sf18.service.impl.MyRepositoryFactoryBean;
import vn.topica.sf18.service.impl.MyRepositoryImpl;

@Configuration
@EnableJpaRepositories(
    repositoryBaseClass = MyRepositoryImpl.class,
    repositoryFactoryBeanClass = MyRepositoryFactoryBean.class)
@Slf4j
public class ModuleConfiguration {

  @PostConstruct
  public void init(){
    log.info("init configuration success");
  }
}
