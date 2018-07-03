package vn.topica.sf18.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, X> extends PagingAndSortingRepository<T, Serializable>,
        JpaSpecificationExecutor<T> {

    @Query("SELECT obj FROM T obj WHERE obj.id IN :ids")
    List<T> findByIds(@Param("ids") Long[] ids);
}
