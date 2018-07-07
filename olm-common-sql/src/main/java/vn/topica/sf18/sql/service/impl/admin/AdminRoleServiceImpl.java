package vn.topica.sf18.sql.service.impl.admin;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.admin.AdminRole;
import vn.topica.sf18.sql.repository.admin.AdminRoleRepository;
import vn.topica.sf18.service.admin.AdminRoleService;

@AllArgsConstructor
@Service
@Slf4j
public class AdminRoleServiceImpl implements AdminRoleService {

  private AdminRoleRepository adminRoleRepository;

  @Override
  public AdminRole findByName(String name) {
    return adminRoleRepository.findByName(name);
  }

  @Override
  public List<AdminRole> findRolesByUsername(String username) {
    return adminRoleRepository.findRolesByUsername(username);
  }

  @Override
  public AdminRole save(AdminRole baseObject) {
    return adminRoleRepository.save(baseObject);
  }

  @Override
  public Iterable<AdminRole> findByIds(Iterable<Long> ids) {
    return null;
//    return adminRoleRepository.findAllById(ids);
  }

  @Override
  public List<AdminRole> filter(String search, Long userId, int pageIndex, int pageSize) {
    return null;
//    return adminRoleRepository.filter(search, userId, pageIndex, pageSize);
  }
}
