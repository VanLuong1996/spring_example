package vn.topica.sf18.excel;

import vn.topica.sf18.excel.model.FileColumnData;
import vn.topica.sf18.excel.service.ImportFile;

public class TestImportAdwordsCsvFile {

    public static void main(String[] args) {
      String filePath = "/home/grapes/TOPICA/excelfilehandling/DemoAdwordsCSV.csv";

      ImportFile importAdwordsCsvFile = new ImportAdwordsCsvFile();
      importAdwordsCsvFile.importFileData(filePath);

      for (FileColumnData columnData : importAdwordsCsvFile.dataImport.getColumnDataList()) {
        System.out.println(columnData.getCampaign_id());
      }
    }
}
