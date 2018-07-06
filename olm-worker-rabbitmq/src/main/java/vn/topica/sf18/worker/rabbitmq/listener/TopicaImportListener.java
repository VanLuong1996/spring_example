package vn.topica.sf18.worker.rabbitmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.topica.TopicaImport;

@Service
@Slf4j
public class TopicaImportListener {

  @RabbitListener(queues = "${app.queue.import}")
  public void handle(TopicaImport message) {
    log.info("Get message {}", message);
  }
}
