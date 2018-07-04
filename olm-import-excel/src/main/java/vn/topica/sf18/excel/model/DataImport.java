package vn.topica.sf18.excel.model;

import java.util.ArrayList;
import java.util.List;

public class DataImport {

  private List<FileColumnData> columnDataList = new ArrayList<>();

  public void addNewColumnData(FileColumnData columnData) {
    columnDataList.add(columnData);
  }

  public List<FileColumnData> getColumnDataList() {
    return columnDataList;
  }
}
