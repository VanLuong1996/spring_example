package vn.topica.sf18.utils.testFileImport;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import vn.topica.sf18.constant.FileColumn;
import vn.topica.sf18.model.fileImport.FileColumnData;
import vn.topica.sf18.service.fileImport.ImportFile;

import java.io.*;
import java.util.Iterator;

public class ImportExcelFile implements ImportFile {
    private Workbook workbook;
    private Row headers;
    private Iterator<Row> rowIterator;

    public void importFileData(String fileURL) {
        try {
            InputStream excelFile = new FileInputStream(new File(fileURL));
           // InputStream excelFile = new URL(fileURL).openStream();
            workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            DataFormatter fmt = new DataFormatter();
            rowIterator = datatypeSheet.iterator();
            headers = rowIterator.next();

            mapColumnID();
            saveFileData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mapColumnID() {
        for (Cell cell : headers) {
            int columnCode = Integer.parseInt(cell.getStringCellValue());
            int columnIndex = cell.getColumnIndex();

            //System.out.println(columnCode + " " + columnIndex);

            for (FileColumn column : FileColumn.values()) {
                if (columnCode == column.getCode()) {
                    columnMapping.put(new Integer(columnIndex), column);
                  //  System.out.println(column + " " + columnIndex);
                }
            }
        }
    }

    public void saveFileData() {
        DataFormatter formatter = new DataFormatter();

        while (rowIterator.hasNext()) {
            Row currentRow = rowIterator.next();
            FileColumnData columnData = new FileColumnData();

            for (Cell cell : currentRow) {
                int columnIndex = cell.getColumnIndex();
                FileColumn columnCode = columnMapping.get(new Integer(columnIndex));
                String cellValue = formatter.formatCellValue(cell);//cell.getStringCellValue();
               // System.out.println(columnIndex + " " + columnCode + " " + cellValue);
                if (cellValue != null){
                    columnData.setDataFromColumnCode(columnCode, cellValue);
                } else {
                  //  System.out.println(columnCode.toString());
                }
            }

            dataImport.addNewColumnData(columnData);
        }
    }

}