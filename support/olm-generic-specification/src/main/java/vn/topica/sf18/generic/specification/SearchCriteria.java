package vn.topica.sf18.generic.specification;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SearchCriteria {

  private String key;
  private SearchOperation operation;
  private Object value;
}
