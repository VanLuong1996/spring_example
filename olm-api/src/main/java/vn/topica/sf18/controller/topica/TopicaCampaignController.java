package vn.topica.sf18.controller.topica;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topica")
@Slf4j
public class TopicaCampaignController {
  @Autowired
  private TopicaCampaignService topicaCampaignService;

  @Autowired
  private TopicaLogService topicaLogService;

  @GetMapping("/campaign")
  public List<TopicaCampaign> get() {
    log.info("(get)");

    List<TopicaCampaign> campaigns = topicaCampaignService.filter("", null, 0, 1000);
    log.info("size {}", campaigns.size());
    return campaigns;
  }

  @GetMapping("/campaign/{id}")
  public TopicaCampaign getById(@PathVariable long id) {
    log.info("(get campaign) ", Id);

    TopicaCampaign campaign = topicaCampaignService.findById(id);
    return campaign;
  }

  @PutMapping("/campaign")
  public void mappingCampaign( @RequestBody List<TopicaCampaign> campaigns) {
    log.info("(mapping campaign) {}");

    //->get userId
    //add log //action = MARKETER_UPDATE_CAMPAIGN_DETAIL
    //log = new TopicaLog(createdBy, action, description);
    //topicaLogService.save(log);
    topicaCampaignService.update(campaigns);
  }

  @GetMapping("/campaign")
  public void report(@RequestParam long fromDate, @RequestParam long toDate){
    log.info("(insert) {}", name);

    topicaCampaignService.report(fromDate, toDate);
  }
}
