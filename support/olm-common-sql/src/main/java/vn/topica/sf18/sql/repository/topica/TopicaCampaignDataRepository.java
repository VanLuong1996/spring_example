package vn.topica.sf18.sql.repository.topica;

import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.topica.sf18.model.topica.TopicaCampaignData;

public interface TopicaCampaignDataRepository extends
    PagingAndSortingRepository<TopicaCampaignData, Long>,
    JpaSpecificationExecutor<TopicaCampaignData> {

  @Query("SELECT obj FROM TopicaCampaignData obj WHERE obj.id IN :ids")
  List<TopicaCampaignData> findByIds(@Param("ids") Iterable<Long> ids);
}
