package vn.topica.sf18.service.admin;

import vn.topica.sf18.model.admin.AdminRole;

import java.util.List;

public interface AdminRoleService {

    AdminRole save(AdminRole baseObject);

    //region admin-on-rest
    List<AdminRole> findByIds(Long[] ids);

    List<AdminRole> filter(String search, Long userId, int pageIndex, int pageSize);


    AdminRole findByName(String name);

    List<AdminRole> findRolesByUsername(String username);
}
