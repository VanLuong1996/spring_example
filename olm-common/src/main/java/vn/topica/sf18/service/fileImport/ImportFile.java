package vn.topica.sf18.service.fileImport;

import vn.topica.sf18.constant.FileColumn;
import vn.topica.sf18.model.fileImport.DataImport;

import java.util.HashMap;

public interface ImportFile {
    //mapping column with enum type
    HashMap<Integer, FileColumn> columnMapping = new HashMap<>();
    // public List<FileColumnData> fileColumnData = new ArrayList<FileColumnData>();
    DataImport dataImport = new DataImport();

    //import data from file
    void importFileData(String fileURL);
}
