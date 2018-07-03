package vn.topica.sf18.controller.topica.dm4c;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.topica.sf18.model.topica.dm4c.TopicaActivity;
import vn.topica.sf18.service.topica.dm4c.TopicaActivityService;

@RestController
@RequestMapping("/api/topica/dm4c")
@Slf4j
public class TopicaActivityController {

  @Autowired
  private TopicaActivityService activityService;

  @GetMapping("/activities")
  public void get() {
    log.info("(get)");
    activityService.filter("", null, 1, 1000);
  }

  @PostMapping("/activities")
  public void insert(String name) {
    log.info("(insert) {}", name);
    activityService.save(new TopicaActivity(name));
  }
}
