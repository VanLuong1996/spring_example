package vn.topica.sf18.model.topica;

import lombok.Data;
import vn.topica.sf18.constant.FileImportStatus;
import vn.topica.sf18.constant.FileImportType;
import vn.topica.sf18.model.BaseModel;

@Data
public class TopicaImport extends BaseModel {

    private Long id;

    private String path;

    private String url;

    private FileImportStatus status;

    private FileImportType type;
}
