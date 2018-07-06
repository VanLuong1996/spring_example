package vn.topica.sf18.worker.redis.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.topica.TopicaImport;

@Service
@Slf4j
public class TopicaImportReceiver {

  public void receiveMessage(Object object) {
    TopicaImport topicaImport = (TopicaImport) object;
  }
}
