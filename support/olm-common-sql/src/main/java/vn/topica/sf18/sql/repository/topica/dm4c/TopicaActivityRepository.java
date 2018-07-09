package vn.topica.sf18.sql.repository.topica.dm4c;

import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.topica.sf18.model.topica.dm4c.TopicaActivity;

public interface TopicaActivityRepository extends
    PagingAndSortingRepository<TopicaActivity, Integer>,
    JpaSpecificationExecutor<TopicaActivity> {

  @Query("SELECT obj FROM TopicaActivity obj WHERE obj.id IN :ids")
  List<TopicaActivity> findByIds(@Param("ids") Iterable<Integer> ids);
}
