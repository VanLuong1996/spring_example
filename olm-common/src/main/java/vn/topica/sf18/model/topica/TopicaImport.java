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

  public static TopicaImport ofGAC(String path) {
    TopicaImport topicaImport = new TopicaImport();
    topicaImport.setPath(path);
    topicaImport.setStatus(FileImportStatus.UPLOADED);
    topicaImport.setType(FileImportType.GOOGLE_ADWORDS_CSV);

    return topicaImport;
  }

  public static TopicaImport ofGS(String url) {
    TopicaImport topicaImport = new TopicaImport();
    topicaImport.setUrl(url);
    topicaImport.setStatus(FileImportStatus.UPLOADED);
    topicaImport.setType(FileImportType.GOOGLE_SPREADSHEET);

    return topicaImport;
  }
}
