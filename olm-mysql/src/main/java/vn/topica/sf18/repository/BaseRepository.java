package vn.topica.sf18.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends
    PagingAndSortingRepository<T, ID>,
    JpaSpecificationExecutor<T> {

  List<T> filter(String search, Long userId, int pageIndex, int pageSize);
}
