package vn.topica.sf18.model.topica;

import lombok.Data;
import vn.topica.sf18.constant.UserAction;

@Data
public class TopicaLog {

  private Long id;

  protected String createdBy;

  private UserAction action;

  private String description;

  public TopicaLog(Long id, String createdBy, UserAction action, String description) {
    this.id = id;
    this.createdBy = createdBy;
    this.action = action;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public UserAction getAction() {
    return action;
  }

  public void setAction(UserAction action) {
    this.action = action;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
