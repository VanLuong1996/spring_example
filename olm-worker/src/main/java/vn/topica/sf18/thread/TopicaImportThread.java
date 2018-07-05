package vn.topica.sf18.thread;

import vn.topica.sf18.model.topica.TopicaImport;
import vn.topica.sf18.service.topica.TopicaImportService;

public class TopicaImportThread extends Thread {

  private TopicaImport topicaImport;

  private TopicaImportService service;

  public TopicaImportThread(TopicaImport topicaImport, TopicaImportService service) {
    this.topicaImport = topicaImport;
    this.service = service;
  }

  public void run() {
    service.save(topicaImport);
  }
}
