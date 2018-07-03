package vn.topica.sf18.repository.topica;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.topica.sf18.model.topica.TopicaCampaign;

public interface TopicaCampaignRepository extends PagingAndSortingRepository<TopicaCampaign, Long>,
        JpaSpecificationExecutor<TopicaCampaign> {

    Page<TopicaCampaign> findAll(Pageable pageable);
}