package vn.topica.sf18.api.controller.topica;

import java.security.Principal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vn.topica.sf18.api.storage.service.StorageService;
import vn.topica.sf18.constant.FileImportStatus;
import vn.topica.sf18.constant.UserAction;
import vn.topica.sf18.model.topica.TopicaImport;
import vn.topica.sf18.model.topica.TopicaLog;
import vn.topica.sf18.service.topica.TopicaImportService;
import vn.topica.sf18.service.topica.TopicaLogService;

@RestController
@RequestMapping("/api/topica")
@Slf4j
public class TopicaImportController {

  @Autowired
  private StorageService storageService;

  @Autowired
  private TopicaImportService topicaImportService;

  @Autowired
  private TopicaLogService topicaLogService;

  @GetMapping("/import")
  public List<TopicaImport> filter(Principal principal, @RequestParam String search,
      @RequestParam int pageIndex, @RequestParam int pageSize) {
    log.info("(filter) {} {} {} {}", principal.getName(), search, pageIndex, pageSize);
    TopicaLog topicaLog = TopicaLog.of(principal.getName(), UserAction.USER_FILTER_IMPORT_FILE, search + "|" + pageIndex + "|" + pageSize);
    topicaLogService.save(topicaLog);

    List<TopicaImport> importList = topicaImportService.filter(search, principal.getName(), pageIndex, pageSize);
    log.info("(filter) size {}", importList.size());
    return importList;
  }

  @GetMapping("/import/{id}")
  public TopicaImport findById(Principal principal, @PathVariable long id) {
    log.info("(findById) {} {}", principal.getName(), id);
    TopicaLog topicaLog = TopicaLog.of(principal.getName(), UserAction.USER_FIND_BY_ID_IMPORT_FILE, Long.toString(id));
    topicaLogService.save(topicaLog);

    return topicaImportService.findById(id);
  }

  @PostMapping("/import")
  public void save(Principal principal, @RequestParam("file") MultipartFile file) {
    log.info("(save) {} {}", principal.getName(), file.getName());
    String filePath = storageService.store(file);

    TopicaLog topicaLog = TopicaLog.of(principal.getName(), UserAction.MARKETER_IMPORT_FILE, file.getName() + "|" + filePath);
    topicaLogService.save(topicaLog);

    topicaImportService.save(TopicaImport.ofGExcel(filePath));
  }

  @PutMapping("/import/{id}")
  public int updatePath(Principal principal, @PathVariable("id") long id,
      @RequestParam("file") MultipartFile file) {
    log.info("(updatePath) {}, {}, {}", principal.getName(), id, file.getName());

    String filePath = storageService.store(file);
    return topicaImportService.updatePath(id, filePath);
  }

  @PutMapping("/import")
  public int updateStatus(Principal principal, @RequestParam List<Long> ids,
      @RequestParam FileImportStatus status) {
    log.info("(updateStatus) {} {} {}", principal.getName(), ids, status);

    for(Long id: ids){
      topicaImportService.updateStatus(id, status);
    }

    return 1;
  }

}
