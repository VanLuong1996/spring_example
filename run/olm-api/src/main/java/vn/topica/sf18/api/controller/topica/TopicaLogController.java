package vn.topica.sf18.api.controller.topica;

import java.security.Principal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.topica.sf18.model.topica.TopicaLog;
import vn.topica.sf18.service.topica.TopicaLogService;

@RestController
@RequestMapping("/api/topica")
@Slf4j
public class TopicaLogController {

  @Autowired
  private TopicaLogService topicaLogService;

  @GetMapping("/log")
  public List<TopicaLog> filter(Principal principal, @RequestParam String search,
      @RequestParam int pageIndex, @RequestParam int pageSize) {
    List<TopicaLog> logs = topicaLogService.filter(search, principal.getName(), pageIndex, pageSize);
    log.info("(filter) size {}", logs.size());
    return logs;
  }
}
