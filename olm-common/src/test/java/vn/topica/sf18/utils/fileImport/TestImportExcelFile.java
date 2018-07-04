package vn.topica.sf18.utils.fileImport;

import vn.topica.sf18.model.fileImport.FileColumnData;
import vn.topica.sf18.service.fileImport.ImportFile;

public class TestImportExcelFile {

  public static void main(String[] args) {
    ImportFile importFile = new ImportExcelFile();

    String fileURL = "https://drive.google.com/file/d/1TpyV2U9-L2SCnexNX0F5qDe9A6keILI7/view?usp=sharing";
    importFile.importFileData("/home/grapes/TOPICA/excelfilehandling/sampletemplatefile.xlsx");

    for (FileColumnData columnData : importFile.dataImport.getColumnDataList()) {
      System.out.println(columnData.getAccount());
    }

      /* for (FileColumn fileColumn: FileColumn.values()){
           System.out.println(fileColumn + " " + fileColumn.getCode());
       }*/
  }
}
