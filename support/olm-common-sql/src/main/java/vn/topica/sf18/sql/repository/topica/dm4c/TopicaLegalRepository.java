package vn.topica.sf18.sql.repository.topica.dm4c;

import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.topica.sf18.model.topica.dm4c.TopicaLegal;

public interface TopicaLegalRepository extends PagingAndSortingRepository<TopicaLegal, Long>,
    JpaSpecificationExecutor<TopicaLegal> {

  @Query("SELECT obj FROM TopicaLegal obj WHERE obj.id IN :ids")
  List<TopicaLegal> findByIds(@Param("ids") Iterable<Integer> ids);
}
