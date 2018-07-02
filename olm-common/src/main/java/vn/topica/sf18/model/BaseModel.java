package vn.topica.sf18.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BaseModel {

    protected Timestamp createdDate;

    protected Timestamp lastModifiedDate;

    protected String createdBy;

    protected String lastModifiedBy;
}
