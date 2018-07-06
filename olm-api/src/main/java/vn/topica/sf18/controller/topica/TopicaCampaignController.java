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

  @GetMapping("/campaign")
  public List<TopicaCampaign> get(@RequestHeader String sessionkey) {
    log.info("(get)");

    //TODO: check session key
    List<TopicaCampaign> campaigns = topicaCampaignService.filter("", null, 0, 1000);
    log.info("size {}", campaigns.size());
    return campaigns;
  }

  @GetMapping("/campaign/{id}")
  public TopicaCampaign getById(@RequestHeader String sessionkey, @PathVariable long id) {
    log.info("(get campaign) ", Id);

    //TODO: check session key
    TopicaCampaign campaign = topicaCampaignService.findById(id);
    return campaign;
  }

  @PutMapping("/campaign")
  public void mappingCampaign(@RequestHeader String sessionkey, @RequestBody List<TopicaCampaign> campaigns) {
    log.info("(mapping campaign) {}");

    //TODO: check session key
    topicaCampaignService.update(campaigns);
  }

  @GetMapping("/campaign")
  public void report(@RequestHeader String sessionkey, @RequestParam long fromDate, @RequestParam long toDate){
    log.info("(insert) {}", name);

    //TODO: check session key
    topicaCampaignService.report(fromDate, toDate);
  }
}
