package vn.topica.sf18.sql.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import javax.persistence.EntityManager;
import net.friend.common.spring.boot.generic.specification.GenericSpecificationsBuilder;
import net.friend.common.spring.boot.generic.specification.SearchCriteria;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import vn.topica.sf18.sql.repository.MyRepository;
import vn.topica.sf18.sql.specification.BaseSpecification;

//@Repository
public class MyRepositoryImpl<T, ID extends Serializable>
    extends SimpleJpaRepository<T, ID> implements MyRepository<T, ID> {

  private final JpaEntityInformation<T, ?> entityInformation;
  private final EntityManager entityManager;

  // There are two constructors to choose from, either can be used.
  public MyRepositoryImpl(JpaEntityInformation<T, ?> entityInformation,
      EntityManager entityManager) {
    super(entityInformation, entityManager);

    // This is the recommended method for accessing inherited class dependencies.
    this.entityInformation = entityInformation;
    this.entityManager = entityManager;
  }

  @Override
  public List<T> filter(String search, Long userId, int pageIndex, int pageSize) {
    GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
    Function<SearchCriteria, Specification<T>> converter = BaseSpecification::new;
    Specification<T> spec = builder.build(converter, search);
    return this.findAll(spec, new PageRequest(pageIndex - 1, pageSize)).getContent();
  }
}
