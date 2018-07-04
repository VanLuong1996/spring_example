package vn.topica.sf18.model;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class BaseModel {

  protected Timestamp createdDate;

  protected Timestamp lastModifiedDate;

  protected String createdBy;

  protected String lastModifiedBy;
}
