package vn.topica.sf18;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import vn.topica.sf18.queue.TopicaImportQueue;
import vn.topica.sf18.service.topica.TopicaImportService;
import vn.topica.sf18.thread.TopicaImportRunnable;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class Application implements CommandLineRunner {

  @Autowired
  private TopicaImportQueue topicaImportQueue;

  @Autowired
  private TopicaImportService topicaImportService;

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }

  @Override
  public void run(String... args) {
    log.info("Run application");

    try{
      while(true){
        if(!topicaImportQueue.isEmpty()){
          TopicaImportRunnable topicaImportRunnable = new TopicaImportRunnable(topicaImportQueue.poll(), topicaImportService);
          Thread thread = new Thread(topicaImportRunnable, "Topica Import");
          thread.start();
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
