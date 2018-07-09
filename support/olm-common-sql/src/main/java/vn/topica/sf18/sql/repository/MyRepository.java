package vn.topica.sf18.sql.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface MyRepository<T, ID extends Serializable> extends
    PagingAndSortingRepository<T, ID>,
    JpaSpecificationExecutor<T> {

  List<T> filter(String search, Long userId, int pageIndex, int pageSize);
}
