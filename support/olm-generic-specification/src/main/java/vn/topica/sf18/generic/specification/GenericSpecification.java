package vn.topica.sf18.generic.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class GenericSpecification<U> {

  private static GenericSpecification ourInstance = new GenericSpecification();

  private GenericSpecification() {

  }

  public static GenericSpecification getInstance(SearchCriteria criteria) {
    return ourInstance;
  }

  public Predicate toPredicate(Root<U> root, CriteriaQuery<?> criteriaQuery,
      CriteriaBuilder criteriaBuilder, SearchCriteria criteria) {

    switch (criteria.getOperation()) {
      case EQUALITY:
        //firstName:john
        if (criteria.getKey().equals("status")) {
          return criteriaBuilder
              .equal(root.get(criteria.getKey()), Integer.parseInt(criteria.getValue().toString()));
        }

        if (criteria.getKey().contains("createdAtEndTime")) {
          return criteriaBuilder.lessThan(root.get("createdAt"), criteria.getValue().toString());
        }

        if (criteria.getKey().contains("createdAtStartTime")) {
          return criteriaBuilder.greaterThan(root.get("createdAt"), criteria.getValue().toString());
        }

        if (criteria.getKey().contains("updatedAtEndTime")) {
          return criteriaBuilder.lessThan(root.get("updatedAt"), criteria.getValue().toString());
        }

        if (criteria.getKey().contains("updatedAtStartTime")) {
          return criteriaBuilder.greaterThan(root.get("updatedAt"), criteria.getValue().toString());
        }

        if (criteria.getKey().equals("createdBy")) {
          return criteriaBuilder.equal(root.get(criteria.getKey()),
              Long.parseLong(criteria.getValue().toString()));
        }

        return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());

      case NEGATION:
        //firstName!john
        return criteriaBuilder.notEqual(root.get(criteria.getKey()), criteria.getValue());

      case GREATER_THAN:
        //age>25
        return criteriaBuilder
            .greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());

      case LESS_THAN:
        //age<25
        return criteriaBuilder
            .lessThan(root.get(criteria.getKey()), criteria.getValue().toString());

      case LIKE:
        //firstname~jo
        return criteriaBuilder
            .like(root.get(criteria.getKey()), "%" + criteria.getValue().toString().trim() + "%");

      case STARTS_WITH:
        //firstName:jo*
        return criteriaBuilder
            .like(root.get(criteria.getKey()), criteria.getValue().toString().trim() + "%");

      case ENDS_WITH:
        //firstName:*n
        return criteriaBuilder
            .like(root.get(criteria.getKey()), "%" + criteria.getValue().toString().trim());

      case CONTAINS:
        //firstName:*oh*
        return criteriaBuilder.like(root.get(
            criteria.getKey()), "%" + criteria.getValue().toString().trim() + "%");

      default:
        return null;
    }
  }
}
