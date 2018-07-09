package vn.topica.sf18.worker.rabbitmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.topica.TopicaImport;
import vn.topica.sf18.service.CommonService;

@Service
@Slf4j
public class TopicaImportListener {

  @Autowired
  private CommonService commonService;

  @RabbitListener(queues = "${app.queue.import}")
  public void process(TopicaImport topicaImport) {
    log.info("Process import {}", topicaImport);
    commonService.processImport(topicaImport);
  }
}
