package vn.topica.sf18.service.admin;

import vn.topica.sf18.model.admin.AdminUser;
import vn.topica.sf18.service.BaseService;

public interface AdminUserService extends BaseService<AdminUser> {

  AdminUser findByUsername(String username);
}
