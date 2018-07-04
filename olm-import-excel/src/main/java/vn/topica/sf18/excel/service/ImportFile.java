package vn.topica.sf18.excel.service;

import java.util.HashMap;
import vn.topica.sf18.excel.constant.FileColumn;
import vn.topica.sf18.excel.model.DataImport;

public interface ImportFile {
    //mapping column with enum type
    HashMap<Integer, FileColumn> columnMapping = new HashMap<>();
    // public List<FileColumnData> fileColumnData = new ArrayList<FileColumnData>();
    DataImport dataImport = new DataImport();

    //import data from file
    void importFileData(String fileURL);
}
