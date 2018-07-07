package vn.topica.sf18.sql.repository.topica;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.topica.sf18.model.topica.TopicaLog;

public interface TopicaLogRepository extends PagingAndSortingRepository<TopicaLog, Long>,
    JpaSpecificationExecutor<TopicaLog> {

}
