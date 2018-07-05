package vn.topica.sf18.thread;

import lombok.extern.slf4j.Slf4j;
import vn.topica.sf18.model.topica.TopicaImport;
import vn.topica.sf18.service.topica.TopicaImportService;

@Slf4j
public class TopicaImportRunnable implements Runnable {

  private TopicaImport topicaImport;

  private TopicaImportService service;

  public TopicaImportRunnable(TopicaImport topicaImport, TopicaImportService service) {
    this.topicaImport = topicaImport;
    this.service = service;
  }

  @Override
  public void run() {
    log.info("TopicaImport {}", topicaImport);
    service.save(topicaImport);
  }
}
