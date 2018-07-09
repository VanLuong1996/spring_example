package vn.topica.sf18.sql.repository.topica;

import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.topica.sf18.constant.FileImportStatus;
import vn.topica.sf18.model.topica.TopicaImport;

public interface TopicaImportRepository extends PagingAndSortingRepository<TopicaImport, Long>,
    JpaSpecificationExecutor<TopicaImport> {

  @Query("SELECT obj FROM TopicaImport obj WHERE obj.id IN :ids")
  List<TopicaImport> findByIds(@Param("ids") Iterable<Long> ids);

  @Modifying
  @Query("update TopicaImport obj set obj.path = :path where obj.id = :id")
  int updatePath(@Param("id") Long id, @Param("path") String path);

  @Modifying
  @Query("update TopicaImport obj set obj.status = :status where obj.id = :id")
  int updateStatus(@Param("id") Long id, @Param("status") FileImportStatus status);
}
