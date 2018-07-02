package vn.topica.sf18.service.impl.admin;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.admin.AdminUser;
import vn.topica.sf18.repository.admin.AdminUserRepository;
import vn.topica.sf18.service.admin.AdminUserService;
import vn.topica.sf18.service.impl.BaseServiceImpl;

@AllArgsConstructor
//@Service
@Slf4j
public class AdminUserServiceImpl extends BaseServiceImpl<AdminUser, Long> implements AdminUserService {

    private AdminUserRepository adminUserRepository;

    @Override
    public AdminUser findByEmail(String email) {
        return adminUserRepository.findByEmail(email);
    }

    @Override
    public AdminUser findByUsername(String username) {
        return adminUserRepository.findByUsername(username);
    }
}
