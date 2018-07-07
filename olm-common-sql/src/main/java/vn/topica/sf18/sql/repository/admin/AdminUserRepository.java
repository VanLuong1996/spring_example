package vn.topica.sf18.sql.repository.admin;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.topica.sf18.model.admin.AdminUser;

/**
 *
 */
public interface AdminUserRepository extends PagingAndSortingRepository<AdminUser, Long>,
    JpaSpecificationExecutor<AdminUser> {

  AdminUser findByUsername(String username);
}
