package vn.topica.sf18.sql.repository.topica.dm4c;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.topica.sf18.model.topica.dm4c.TopicaLegal;

public interface TopicaLegalRepository extends PagingAndSortingRepository<TopicaLegal, Long>,
    JpaSpecificationExecutor<TopicaLegal> {

}
