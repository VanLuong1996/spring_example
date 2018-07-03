package vn.topica.sf18.repository.topica;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.topica.sf18.model.topica.TopicaCampaignData;

public interface TopicaCampaignDataRepository extends PagingAndSortingRepository<TopicaCampaignData, Long>,
        JpaSpecificationExecutor<TopicaCampaignData> {

    Page<TopicaCampaignData> findAll(Pageable pageable);
}