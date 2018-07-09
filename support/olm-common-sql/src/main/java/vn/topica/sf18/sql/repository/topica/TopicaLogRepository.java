package vn.topica.sf18.sql.repository.topica;

import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.topica.sf18.model.topica.TopicaLog;

public interface TopicaLogRepository extends PagingAndSortingRepository<TopicaLog, Long>,
    JpaSpecificationExecutor<TopicaLog> {

  @Query("SELECT obj FROM TopicaLog obj WHERE obj.id IN :ids")
  List<TopicaLog> findByIds(@Param("ids") Iterable<Long> ids);
}
