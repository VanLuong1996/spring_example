package vn.topica.sf18.sql.repository.topica.dm4c;

import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.topica.sf18.model.topica.dm4c.TopicaEstimator;

public interface TopicaEstimatorRepository extends
    PagingAndSortingRepository<TopicaEstimator, Long>,
    JpaSpecificationExecutor<TopicaEstimator> {

  @Query("SELECT obj FROM TopicaEstimator obj WHERE obj.id IN :ids")
  List<TopicaEstimator> findByIds(@Param("ids") Iterable<Integer> ids);
}
