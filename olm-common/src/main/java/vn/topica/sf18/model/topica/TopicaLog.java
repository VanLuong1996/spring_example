package vn.topica.sf18.model.topica;

import lombok.Data;
import vn.topica.sf18.constant.UserAction;

@Data
public class TopicaLog {

    private Long id;

    protected String createdBy;

    private UserAction action;

    private String description;
}
