package vn.topica.sf18.sql.repository.admin;

import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.topica.sf18.model.admin.AdminPermission;

public interface AdminPermissionRepository extends
    PagingAndSortingRepository<AdminPermission, Long>,
    JpaSpecificationExecutor<AdminPermission> {

  @Query("SELECT obj FROM AdminPermission obj WHERE obj.id IN :ids")
  List<AdminPermission> findByIds(@Param("ids") Iterable<Long> ids);
}
