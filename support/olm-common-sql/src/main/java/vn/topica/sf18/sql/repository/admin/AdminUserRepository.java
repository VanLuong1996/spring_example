package vn.topica.sf18.sql.repository.admin;

import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.topica.sf18.model.admin.AdminUser;

public interface AdminUserRepository extends PagingAndSortingRepository<AdminUser, Long>,
    JpaSpecificationExecutor<AdminUser> {

  AdminUser findByUsername(String username);

  @Query("SELECT obj FROM AdminUser obj WHERE obj.id IN :ids")
  List<AdminUser> findByIds(@Param("ids") Iterable<Long> ids);
}
