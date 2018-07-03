package vn.topica.sf18.utils.testFileImport;

import vn.topica.sf18.model.fileImport.FileColumnData;
import vn.topica.sf18.service.fileImport.ImportFile;

public class TestImportSpreadsheetFile {
    public static void main(String[] args) {
        ImportFile importFile = new ImportSpreadsheetFile();

        String fileURL = "https://docs.google.com/spreadsheets/d/1XrG7C9M-LKzh8tDR-Z6qAMGF_mbS1ydo4-lKO8bEXkc/edit?usp=drive_web&ouid=113861197619401737503";
        importFile.importFileData(fileURL);

        for (FileColumnData columnData: importFile.dataImport.getColumnDataList()){
            System.out.println(columnData.getAccount());
        }
    }
}
