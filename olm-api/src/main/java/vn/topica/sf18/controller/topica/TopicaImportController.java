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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.topica.sf18.model.topica.TopicaImport;
import vn.topica.sf18.service.topica.TopicaCampaignService;
import vn.topica.sf18.service.topica.TopicaImportService;
import vn.topica.sf18.service.topica.TopicaLogService;

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
  public List<TopicaImport> get() {
    log.info("(get)");

    List<TopicaImport> importList = topicaImportService.filter("", null, 0, 1000);
    log.info("size {}", importList.size());
    return importList;
  }

  @GetMapping("/import/{Id}")
  public TopicaImport getById(@PathVariable("Id") long id) {
    log.info("(get import info)", id);

    TopicaImport topicaImport = topicaImportService.findById(id);
    return topicaImport;
  }

  @PostMapping("/import")
  public TopicaImport importFile(@Valid @RequestBody String path,
      @Valid @RequestBody FileImportType type) {
    log.info("(import new file) {}", path, type);

    TopicaImport import =topicaImportService.save(path, type);
    topicaCampaignService.extract(import.getId());
    //->get userId
    //add log //action = MARKETER_IMPORT_FILE
    //log = new TopicaLog(createdBy, action, description);
    //topicaLogService.save(log);

    return import;
  }

  @PutMapping("/import/{Id}")
  public void changeImportedFile(@PathVariable("Id") long id, @Valid @RequestBody String path) {
    log.info("(update file) {}", id, path);

    topicaImportService.update(id, path);

    //->get userId
    //add log //action = MARKETER_CHANGE_IMPORTED_FILE
    //log = new TopicaLog(createdBy, action, description);
    //topicaLogService.save(log);
  }

  @PutMapping("/import")
  public void confirmFile(@RequestBody List<long> ids) {
    log.info("(confirm files) {}", listIds);

    topicaImportService.confirm(ids);

    //->get userId
    //add log //action = MANAGER_CONFIRM_IMPORTED_FILE
    //log = new TopicaLog(createdBy, action, description);
    //topicaLogService.save(log);

  }

}
