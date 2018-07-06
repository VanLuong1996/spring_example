package vn.topica.sf18.controller.topica;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topica")
@Slf4j
public class TopicaImportController {
  @Autowired
  private TopicaImportService topicaImportService;

  @Autowired
  private TopicaCampaignService topicaCampaignService;

  @Autowired
  private TopicaLogService topicaLogService;

  @GetMapping("/import")
  public List<TopicaImport> get(@RequestHeader String sessionkey) {
    log.info("(get)");

    //TODO: check session key

    List<TopicaImport> importList = topicaImportService.filter("", null, 0, 1000);
    log.info("size {}", importList.size());
    return importList;
  }

  @GetMapping("/import/{Id}")
  public TopicaImport getById(@RequestHeader String sessionkey, @PathVariable("Id") long id){
    log.info("(get import info)", id);

    //TODO: check session key

    TopicaImport topicaImport = topicaImportService.findById(id);
    return topicaImport;
  }

  @PostMapping("/import")
  public TopicaImport importFile(@RequestHeader String sessionkey, @Valid @RequestBody String path, @Valid @RequestBody FileImportType type){
    log.info("(import new file) {}", path, type);

    //TODO: check session key

    TopicaImport import = topicaImportService.save(path, type);
    topicaCampaignService.extract(import.getId());
    //->get userId
    //add log //action = MARKETER_IMPORT_FILE
    //log = new TopicaLog(createdBy, action, description);
    //topicaLogService.save(log);

    return import;
  }

  @PutMapping("/import/{Id}")
  public void changeImportedFile(@RequestHeader String sessionkey, @PathVariable("Id") long id, @Valid @RequestBody String path){
    log.info("(update file) {}", id, path);

    //TODO: check session key

    topicaImportService.update(id, path);

    //->get userId
    //add log //action = MARKETER_CHANGE_IMPORTED_FILE
    //log = new TopicaLog(createdBy, action, description);
    //topicaLogService.save(log);
  }

  @PutMapping("/import")
  public void confirmFile(@RequestHeader String sessionkey, @RequestBody List<long> ids){
    log.info("(confirm files) {}", listIds);

    //TODO: check session key

    topicaImportService.confirm(ids);

    //->get userId
    //add log //action = MANAGER_CONFIRM_IMPORTED_FILE
    //log = new TopicaLog(createdBy, action, description);
    //topicaLogService.save(log);

  }

}
