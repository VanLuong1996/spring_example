package vn.topica.sf18.generic.specification;

import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import vn.topica.sf18.util.JsonUtil;

public class GenericSpecificationsBuilder<U> {

  private final List<SearchCriteria> params;

  public GenericSpecificationsBuilder() {
    params = new ArrayList<>();
  }

  public GenericSpecificationsBuilder with(String key, String operation, Object value,
      String prefix, String suffix) {
    SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
    if (op != null) {
      if (op == SearchOperation.EQUALITY) {
        boolean startWithAsterisk = prefix.contains("*");
        boolean endWithAsterisk = suffix.contains("*");

        if (startWithAsterisk && endWithAsterisk) {
          op = SearchOperation.CONTAINS;
        } else if (startWithAsterisk) {
          op = SearchOperation.ENDS_WITH;
        } else if (endWithAsterisk) {
          op = SearchOperation.STARTS_WITH;
        }
      }
      params.add(new SearchCriteria(key, op, value));
    }
    return this;
  }

  public Specification<U> build(Function<SearchCriteria, Specification<U>> converter) {
    if (params.size() == 0) {
      return null;
    }

    List<Specification<U>> specs = new ArrayList<>();
    for (SearchCriteria param : params) {
      specs.add(converter.apply(param));
    }

    Specification<U> result = specs.get(0);
    for (int i = 1; i < specs.size(); i++) {
      result = Specifications.where(result).and(specs.get(i));
    }
    return result;
  }

  public Specification<U> build(Function<SearchCriteria, Specification<U>> converter,
      String search) {
    Map<String, Object> searchMap = JsonUtil.convert(search);
    if (searchMap == null) {
      //not json search
      String operationSet = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
      Pattern pattern = Pattern.compile(
          "(\\w+?)(" + operationSet + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
      Matcher matcher = pattern.matcher(search + ",");
      while (matcher.find()) {
        this.with(
            matcher.group(1),
            matcher.group(2),
            matcher.group(4),
            matcher.group(3),
            matcher.group(5));
      }
    } else {
      //json search
      if (searchMap.entrySet().size() > 0) {
        for (Map.Entry<String, Object> entry : searchMap.entrySet()) {
          this.with(entry.getKey(), ":", entry.getValue(), "", "");
        }
      } else {
        this.with("q", ":", "", "", "");
      }
    }

    return this.build(converter);
  }
}
