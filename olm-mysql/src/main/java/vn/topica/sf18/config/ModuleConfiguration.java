package vn.topica.sf18.config;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
//@EnableJpaRepositories(
//    repositoryBaseClass = MyRepositoryImpl.class,
//    repositoryFactoryBeanClass = MyRepositoryFactoryBean.class)
@EnableJpaRepositories("vn.topica.sf18.repository")
@Slf4j
public class ModuleConfiguration {

  @PostConstruct
  public void init(){
    log.info("init configuration success");
  }
}
