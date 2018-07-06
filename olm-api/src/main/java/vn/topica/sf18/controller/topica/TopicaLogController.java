package vn.topica.sf18.controller.topica;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topica")
@Slf4j
public class TopicaLogController {

  @Autowired
  private TopicaLogService topicaLogService;

  @GetMapping("/log")
  public List<TopicaLog> get() {
    log.info("(get)");
    List<TopicaLog> logs = topicaLogService.filter("", null, 0, 1000);
    log.info("size {}", logs.size());
    return logs;
  }

  @GetMapping("/log/{userId}")
  public List<TopicaLog> getByUserId(@PathVariable("userId") long userId) {
    log.info("(get)");
    List<TopicaLog> logs = topicaLogService.findByUserId(userId);
    log.info("size {}", logs.size());
    return logs;
  }
}
