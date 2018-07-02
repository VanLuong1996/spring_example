package vn.topica.sf18.model.topica;

import lombok.Data;
import vn.topica.sf18.constant.UserAction;

@Data
public class TopicaLog {

    protected String createdBy;

    private Long id;

    private UserAction action;

    private String description;
}
