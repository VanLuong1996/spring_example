package vn.topica.sf18.repository.admin;

import vn.topica.sf18.model.admin.AdminUser;
import vn.topica.sf18.repository.MyRepository;

/**
 *
 */
public interface AdminUserRepository extends MyRepository<AdminUser, Long> {

  AdminUser findByUsername(String username);
}
