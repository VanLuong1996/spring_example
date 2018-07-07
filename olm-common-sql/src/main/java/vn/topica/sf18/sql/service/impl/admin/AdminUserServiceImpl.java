package vn.topica.sf18.sql.service.impl.admin;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.admin.AdminUser;
import vn.topica.sf18.sql.repository.admin.AdminUserRepository;
import vn.topica.sf18.service.admin.AdminUserService;

@AllArgsConstructor
@Service
@Slf4j
public class AdminUserServiceImpl implements AdminUserService {

  private AdminUserRepository adminUserRepository;

  @Override
  public AdminUser findByUsername(String username) {
    return adminUserRepository.findByUsername(username);
  }

  @Override
  public AdminUser save(AdminUser baseObject) {
    return adminUserRepository.save(baseObject);
  }

  @Override
  public Iterable<AdminUser> findByIds(Iterable<Long> ids) {
    return null;
//    return adminUserRepository.findAllById(ids);
  }

  @Override
  public List<AdminUser> filter(String search, Long userId, int pageIndex, int pageSize) {
    return null;
//    return adminUserRepository.filter(search, userId, pageIndex, pageSize);
  }
}
