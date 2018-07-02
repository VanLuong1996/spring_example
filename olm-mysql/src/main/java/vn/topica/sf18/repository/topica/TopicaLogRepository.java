package vn.topica.sf18.repository.topica;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.topica.sf18.model.topica.TopicaLog;

public interface TopicaLogRepository extends PagingAndSortingRepository<TopicaLog, Long>,
        JpaSpecificationExecutor<TopicaLog> {

    Page<TopicaLog> findAll(Pageable pageable);
}
