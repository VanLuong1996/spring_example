package vn.topica.sf18.repository.admin;

import vn.topica.sf18.model.admin.AdminUser;
import vn.topica.sf18.repository.BaseRepository;

/**
 * Created by ico on 10/9/17.
 */
public interface AdminUserRepository extends BaseRepository<AdminUser, Long> {

  AdminUser findByUsername(String username);
}
