package vn.topica.sf18.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import vn.topica.sf18.model.topica.TopicaImport;
import vn.topica.sf18.service.topica.TopicaImportService;

@Component
@Slf4j
public class TopicaImportComponent {

  @Autowired
  private TopicaImportService topicaImportService;

  @Async
  public void save(TopicaImport topicaImport){
    topicaImportService.save(topicaImport);
  }

  private void saveUseRunnable(TopicaImport topicaImport){
    TopicaImportRunnable topicaImportRunnable = new TopicaImportRunnable(topicaImport, topicaImportService);
    Thread thread = new Thread(topicaImportRunnable, "Topica Import " + topicaImport.hashCode());
    thread.start();
  }

  private void saveUseThread(TopicaImport topicaImport){
    TopicaImportThread thread = new TopicaImportThread(topicaImport, topicaImportService);
    thread.run();
  }
}
