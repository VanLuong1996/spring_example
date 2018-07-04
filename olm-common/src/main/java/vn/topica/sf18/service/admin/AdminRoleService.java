package vn.topica.sf18.service.admin;

import java.util.List;
import vn.topica.sf18.model.admin.AdminRole;
import vn.topica.sf18.service.BaseService;

public interface AdminRoleService extends BaseService<AdminRole> {

  AdminRole findByName(String name);

  List<AdminRole> findRolesByUsername(String username);
}
