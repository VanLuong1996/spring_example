package vn.topica.sf18;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import vn.topica.sf18.component.TopicaImportComponent;
import vn.topica.sf18.model.topica.TopicaImport;
import vn.topica.sf18.queue.TopicaImportQueue;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class Application implements CommandLineRunner {

  @Autowired
  private TopicaImportComponent topicaImportComponent;

  @Autowired
  private TopicaImportQueue topicaImportQueue;

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }

  @Override
  public void run(String... args) {
    log.info("Run application");
    init();
  }

  private void init(){
    try{
      while(true){
        if(!topicaImportQueue.isEmpty()){
          TopicaImport topicaImport = topicaImportQueue.poll();
          topicaImportComponent.save(topicaImport);
        }else {
          log.debug("Size {}", topicaImportQueue.getSize());
          Thread.sleep(2000L);
        }
      }
    }catch (Exception ex){
      log.error(ExceptionUtils.getStackTrace(ex));
    }
  }
}
