package vn.topica.sf18.service.admin;

import vn.topica.sf18.model.admin.AdminPermission;

import java.util.List;

public interface AdminPermissionService {

    AdminPermission save(AdminPermission baseObject);

    //region admin-on-rest
    List<AdminPermission> findByIds(Long[] ids);

    List<AdminPermission> filter(String search, Long userId, int pageIndex, int pageSize);
}
