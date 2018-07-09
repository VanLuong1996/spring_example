package vn.topica.sf18.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;

public class JsonUtil {

  public static Map<String, Object> convert(String json) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      return mapper.readValue(json, new TypeReference<Map<String, String>>() {
      });
    } catch (IOException ex) {
      return null;
    }
  }
}
