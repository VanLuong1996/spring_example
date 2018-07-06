package vn.topica.sf18.sql.repository.admin;

import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.topica.sf18.model.admin.AdminRole;

/**
 *
 */
public interface AdminRoleRepository extends PagingAndSortingRepository<AdminRole, Long>,
    JpaSpecificationExecutor<AdminRole> {

  AdminRole findByName(String name);

  @Query("SELECT obj FROM AdminRole obj JOIN obj.adminUser u WHERE u.username = :username")
  List<AdminRole> findRolesByUsername(
      @Param("username") String username);
}
