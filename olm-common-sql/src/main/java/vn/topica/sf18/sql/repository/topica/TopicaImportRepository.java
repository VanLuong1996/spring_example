package vn.topica.sf18.sql.repository.topica;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.topica.sf18.model.topica.TopicaImport;

public interface TopicaImportRepository extends PagingAndSortingRepository<TopicaImport, Long>,
    JpaSpecificationExecutor<TopicaImport> {

}
