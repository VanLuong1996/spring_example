package vn.topica.sf18.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.topica.sf18.constant.FileImportStatus;
import vn.topica.sf18.constant.FileImportType;
import vn.topica.sf18.model.topica.TopicaCampaign;
import vn.topica.sf18.model.topica.TopicaImport;
import vn.topica.sf18.service.CommonService;
import vn.topica.sf18.service.topica.TopicaImportService;

@Service
@Slf4j
public class CommonServiceImpl implements CommonService {

  @Autowired
  private TopicaImportService topicaImportService;

  @Override
  public void processCampaign(TopicaCampaign topicaCampaign) {

  }

  @Override
  public void processImport(TopicaImport topicaImport) {
    //import data from EXCEL, GOOGLE_SPREADSHEET, GOOGLE_ADWORDS_CSV
    switch (topicaImport.getType()){
      case EXCEL:
        importExcel(topicaImport.getPath());
        break;
      case GOOGLE_SPREADSHEET:
        importGoogleSpreadSheet(topicaImport.getUrl());
        break;
      case GOOGLE_ADWORDS_CSV:
        importGoogleAdwordsCsv(topicaImport.getPath());
        break;
    }

    topicaImport.setStatus(FileImportStatus.IMPORTED);
    topicaImportService.save(topicaImport);
  }

  private void importExcel(String path){

  }

  private void importGoogleSpreadSheet(String url){

  }

  private void importGoogleAdwordsCsv(String path){

  }
}
