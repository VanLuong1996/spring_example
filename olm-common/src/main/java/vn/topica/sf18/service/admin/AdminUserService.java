package vn.topica.sf18.service.admin;

import vn.topica.sf18.model.admin.AdminUser;

import java.util.List;

public interface AdminUserService {

    AdminUser save(AdminUser baseObject);

    //region admin-on-rest
    List<AdminUser> findByIds(Long[] ids);

    List<AdminUser> filter(String search, Long userId, int pageIndex, int pageSize);


    AdminUser findByEmail(String email);

    AdminUser findByUsername(String username);
}
