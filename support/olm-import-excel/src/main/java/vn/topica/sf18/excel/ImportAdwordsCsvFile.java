package vn.topica.sf18.excel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import vn.topica.sf18.excel.constant.FileColumn;
import vn.topica.sf18.excel.model.FileColumnData;
import vn.topica.sf18.excel.service.ImportFile;

public class ImportAdwordsCsvFile implements ImportFile {

  @Override
  public void importFileData(String fileURL) {
    try {
      FileReader fileReader = new FileReader(fileURL);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      bufferedReader.readLine();
      CSVParser csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT
          .withFirstRecordAsHeader()
          .withIgnoreHeaderCase()
          .withTrim());

      for (CSVRecord csvRecord : csvParser) {
        // Accessing values by Header names
        FileColumnData columnData = new FileColumnData();
        for (FileColumn column : FileColumn.values()) {
          if (column.getName() != null) {
            String columnName = column.getName();
            String cellValue;
            try {
              cellValue = csvRecord.get(columnName);
            } catch (IllegalArgumentException e) {
              e.printStackTrace();
              break;
            }

            if (cellValue != null) {
              columnData.setDataFromColumnCode(column, cellValue);
            } else {
              //  System.out.println(columnCode.toString());
            }

            if (cellValue.equals("Total")) {
              break;
            }
          }
        }
        dataImport.addNewColumnData(columnData);
      }
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
