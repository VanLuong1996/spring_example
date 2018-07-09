package vn.topica.sf18.worker.redis.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.topica.TopicaImport;
import vn.topica.sf18.service.CommonService;

@Service
@Slf4j
public class TopicaImportReceiver {

  @Autowired
  private CommonService commonService;

  public void receiveMessage(Object object) {
    TopicaImport topicaImport = (TopicaImport) object;

    log.info("Process import {}", topicaImport);
    commonService.processImport(topicaImport);
  }
}
