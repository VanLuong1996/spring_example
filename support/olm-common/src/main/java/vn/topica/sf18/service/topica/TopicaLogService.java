package vn.topica.sf18.service.topica;

import java.util.List;
import vn.topica.sf18.constant.UserAction;
import vn.topica.sf18.model.topica.TopicaLog;
import vn.topica.sf18.service.BaseService;

public interface TopicaLogService extends BaseService<TopicaLog, Long> {

  //get log by userID (Admin, Marketer, Manager)
  List<TopicaLog> findByUserId();

  //luu log tac dong
  void save(long createdBy, UserAction action, String description);
}
