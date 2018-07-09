package vn.topica.sf18.model.topica;

import lombok.Data;
import vn.topica.sf18.constant.UserAction;

@Data
public class TopicaLog {

  private Long id;

  private String createdBy;

  private UserAction action;

  private String description;

  public static TopicaLog of(String createdBy, UserAction action, String description){
    TopicaLog topicaLog = new TopicaLog();
    topicaLog.setCreatedBy(createdBy);
    topicaLog.setAction(action);
    topicaLog.setDescription(description);

    return topicaLog;
  }
}
