package vn.topica.sf18.sql.repository.topica;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.topica.sf18.model.topica.TopicaCampaignData;

public interface TopicaCampaignDataRepository extends
    PagingAndSortingRepository<TopicaCampaignData, Long>,
    JpaSpecificationExecutor<TopicaCampaignData> {

}
