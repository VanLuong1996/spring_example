package vn.topica.sf18.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.friend.common.spring.boot.generic.specification.GenericSpecification;
import net.friend.common.spring.boot.generic.specification.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
@NoArgsConstructor
public class BaseSpecification<T> implements Specification<T> {

  private SearchCriteria criteria;

  @Override
  public Predicate toPredicate(
      Root<T> root,
      CriteriaQuery<?> criteriaQuery,
      CriteriaBuilder criteriaBuilder) {
    return GenericSpecification
        .getInstance(criteria).toPredicate(root, criteriaQuery, criteriaBuilder, criteria);
  }
}
