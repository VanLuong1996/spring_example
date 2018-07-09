package vn.topica.sf18.sql.repository.topica;

import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.topica.sf18.model.topica.TopicaCampaign;

public interface TopicaCampaignRepository extends PagingAndSortingRepository<TopicaCampaign, Long>,
    JpaSpecificationExecutor<TopicaCampaign> {

  @Query("SELECT obj FROM TopicaCampaign obj WHERE obj.id IN :ids")
  List<TopicaCampaign> findByIds(@Param("ids") Iterable<Long> ids);
}
