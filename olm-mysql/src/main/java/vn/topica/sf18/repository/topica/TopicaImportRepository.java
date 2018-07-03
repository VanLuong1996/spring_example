package vn.topica.sf18.repository.topica;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.topica.sf18.model.topica.TopicaImport;

public interface TopicaImportRepository extends PagingAndSortingRepository<TopicaImport, Long>,
        JpaSpecificationExecutor<TopicaImport> {

    Page<TopicaImport> findAll(Pageable pageable);
}