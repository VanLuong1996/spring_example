package vn.topica.sf18.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import javax.persistence.EntityManager;
import net.friend.common.spring.boot.generic.specification.GenericSpecificationsBuilder;
import net.friend.common.spring.boot.generic.specification.SearchCriteria;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import vn.topica.sf18.repository.BaseRepository;
import vn.topica.sf18.specification.BaseSpecification;

public class MyRepositoryImpl<T, ID extends Serializable>
    extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

  private EntityManager entityManager;

  // There are two constructors to choose from, either can be used.
  public MyRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
    super(domainClass, entityManager);

    // This is the recommended method for accessing inherited class dependencies.
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
