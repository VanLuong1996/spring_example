package vn.topica.sf18.utils.fileImport;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import vn.topica.sf18.constant.FileColumn;
import vn.topica.sf18.model.fileImport.FileColumnData;
import vn.topica.sf18.service.fileImport.ImportFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ImportSpreadsheetFile implements ImportFile {

  private static final String APPLICATION_NAME = "aa";

  private static final java.io.File DATA_STORE_DIR =
      new java.io.File(
          System.getProperty("user.home"),
          ".credentials/client_secret_35546725757-ops8vreuafgd7o6f57g5blgm02fuoacu.apps.googleusercontent.com");

  private static FileDataStoreFactory DATA_STORE_FACTORY;

  private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

  private static HttpTransport HTTP_TRANSPORT;

  private static final List<String> SCOPES = Arrays.asList(SheetsScopes.SPREADSHEETS_READONLY);

  static {
    try {
      HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
      DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
    } catch (Throwable t) {
      t.printStackTrace();
      System.exit(1);
    }
  }

  public static Credential authorize() throws IOException {
    InputStream in = ImportSpreadsheetFile.class.getResourceAsStream("/client_id.json");
    GoogleClientSecrets clientSecrets = GoogleClientSecrets
        .load(JSON_FACTORY, new InputStreamReader(in));

    GoogleAuthorizationCodeFlow flow =
        new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
            .setDataStoreFactory(DATA_STORE_FACTORY)
            .setAccessType("offline")
            .build();
    Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver())
        .authorize("user");
    System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
    return credential;
  }

  public static Sheets getSheetsService() throws IOException {
    Credential credential = authorize();
    return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
        .setApplicationName(APPLICATION_NAME).build();
  }

  public String getSpreadsheetIDFromURL(String fileURL) {
    String fileID = null;

    int indexOfDSlash = fileURL.indexOf("/d/");
    int indexOfEditSlash = fileURL.indexOf("/edit");

    int lengthOfURL = fileURL.length();

    if (indexOfEditSlash == -1) {
      fileID = fileURL.substring(indexOfDSlash + 3);
    } else {
      fileID = fileURL.substring(indexOfDSlash + 3, indexOfEditSlash);
    }

    return fileID;
  }

  public void importFileData(String fileURL) {
    Sheets service = null;
    try {
      service = getSheetsService();
    } catch (IOException e) {
      e.printStackTrace();
    }

    // https://docs.google.com/spreadsheets/d/1py_1x30bHKuFWqOIp1ihouGJ5yTZgrZ0qOOyJSwOieo/edit#gid=0
    String spreadsheetId = getSpreadsheetIDFromURL(
        fileURL);//"1XrG7C9M-LKzh8tDR-Z6qAMGF_mbS1ydo4-lKO8bEXkc";
    String range = "Sheet1!A1:Q";
    ValueRange response = null;
    try {
      response = service.spreadsheets().values().get(spreadsheetId, range).execute();
    } catch (IOException e) {
      e.printStackTrace();
    }

    List<List<Object>> values = response.getValues();
    if (values == null || values.size() == 0) {
      System.out.println("No data found.");
    } else {
      headers = values.get(0);
      rowIterator = values.iterator();
      rowIterator.next();

      mapColumnID();
      saveFileData();

            /*for (List row : values) {
                System.out.println(row);
            }*/
    }
  }

  private List<Object> headers;
  private Iterator<List<Object>> rowIterator;

  public void mapColumnID() {
    for (int columnIndex = 0; columnIndex < headers.size(); columnIndex++) {
      String headerContent = String.valueOf(headers.get(columnIndex));
      int columnCode = Integer.parseInt(headerContent);

      for (FileColumn column : FileColumn.values()) {
        if (columnCode == column.getCode()) {
          columnMapping.put(new Integer(columnIndex), column);
          //   System.out.println(column + " " + columnIndex);
        }
      }
    }

  }

  public void saveFileData() {
    while (rowIterator.hasNext()) {
      List<Object> row = rowIterator.next();
      FileColumnData columnData = new FileColumnData();

      for (int columnIndex = 0; columnIndex < row.size(); columnIndex++) {
        FileColumn columnCode = columnMapping.get(new Integer(columnIndex));
        Object cell = row.get(columnIndex);
        String cellValue = String.valueOf(cell);//cell.getStringCellValue();

        if (cell != null) {
          columnData.setDataFromColumnCode(columnCode, cellValue);
        } else {
          System.out.println(columnCode.toString());
        }
      }

      dataImport.addNewColumnData(columnData);
    }
  }
}
