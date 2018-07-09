package vn.topica.sf18.api.controller.topica;

import java.security.Principal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.topica.sf18.constant.UserAction;
import vn.topica.sf18.model.topica.TopicaCampaign;
import vn.topica.sf18.model.topica.TopicaLog;
import vn.topica.sf18.service.topica.business.TopicaCampaignBusinessService;
import vn.topica.sf18.service.topica.TopicaCampaignService;
import vn.topica.sf18.service.topica.TopicaLogService;

@RestController
@RequestMapping("/api/topica")
@Slf4j
public class TopicaCampaignController {

  @Autowired
  private TopicaCampaignService topicaCampaignService;

  @Autowired
  private TopicaLogService topicaLogService;

  @Autowired
  private TopicaCampaignBusinessService topicaCampaignBusinessService;

  @GetMapping("/campaign")
  public List<TopicaCampaign> filter(Principal principal, @RequestParam String search,
      @RequestParam int pageIndex, @RequestParam int pageSize) {
    log.info("(filter) {} {} {} {}", principal.getName(), search, pageIndex, pageSize);
    TopicaLog topicaLog = TopicaLog.of(principal.getName(), UserAction.USER_FILTER_CAMPAIGN, search + "|" + pageIndex + "|" + pageSize);
    topicaLogService.save(topicaLog);

    List<TopicaCampaign> campaigns = topicaCampaignService.filter(search, principal.getName(), pageIndex, pageSize);
    log.info("(filter) size {}", campaigns.size());
    return campaigns;
  }

  @GetMapping("/campaign/{id}")
  public TopicaCampaign findById(Principal principal, @PathVariable long id) {
    log.info("(findById) {} {}", principal.getName(), id);
    TopicaLog topicaLog = TopicaLog.of(principal.getName(), UserAction.USER_FIND_BY_ID_CAMPAIGN, Long.toString(id));
    topicaLogService.save(topicaLog);

    return topicaCampaignService.findById(id);
  }

  @PutMapping("/campaign")
  public void map(@RequestBody List<TopicaCampaign> campaigns) {
    log.info("(map) {}", campaigns);
    topicaCampaignBusinessService.map(campaigns);
  }
}
