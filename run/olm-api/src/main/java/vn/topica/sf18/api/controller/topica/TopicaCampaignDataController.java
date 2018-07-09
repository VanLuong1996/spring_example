package vn.topica.sf18.api.controller.topica;

import java.security.Principal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.topica.sf18.constant.UserAction;
import vn.topica.sf18.model.topica.TopicaCampaignData;
import vn.topica.sf18.model.topica.TopicaLog;
import vn.topica.sf18.service.topica.TopicaCampaignDataService;
import vn.topica.sf18.service.topica.TopicaLogService;

@RestController
@RequestMapping("/api/topica")
@Slf4j
public class TopicaCampaignDataController {

  @Autowired
  private TopicaCampaignDataService topicaCampaignDataService;

  @Autowired
  private TopicaLogService topicaLogService;

  @GetMapping("/campaign")
  public List<TopicaCampaignData> filter(Principal principal, @RequestParam String search,
      @RequestParam int pageIndex, @RequestParam int pageSize) {
    log.info("(filter) {} {} {} {}", principal.getName(), search, pageIndex, pageSize);
    TopicaLog topicaLog = TopicaLog.of(principal.getName(), UserAction.USER_FILTER_CAMPAIGN, search + "|" + pageIndex + "|" + pageSize);
    topicaLogService.save(topicaLog);

    List<TopicaCampaignData> data = topicaCampaignDataService.filter(search, principal.getName(), pageIndex, pageSize);
    log.info("(filter) size {}", data.size());
    return data;
  }
}
