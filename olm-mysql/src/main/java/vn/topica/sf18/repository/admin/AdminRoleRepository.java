package vn.topica.sf18.repository.admin;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.topica.sf18.model.admin.AdminRole;
import vn.topica.sf18.repository.MyRepository;

/**
 *
 */
public interface AdminRoleRepository extends MyRepository<AdminRole, Long> {

  AdminRole findByName(String name);

  @Query("SELECT obj FROM AdminRole obj JOIN obj.adminUser u WHERE u.username = :username")
  List<AdminRole> findRolesByUsername(
      @Param("username") String username);
}
