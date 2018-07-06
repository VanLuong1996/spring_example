package vn.topica.sf18.service.impl.admin;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.admin.AdminPermission;
import vn.topica.sf18.repository.admin.AdminPermissionRepository;
import vn.topica.sf18.service.admin.AdminPermissionService;

@AllArgsConstructor
@Service
@Slf4j
public class AdminPermissionServiceImpl implements AdminPermissionService {

  @Autowired
  private AdminPermissionRepository adminPermissionRepository;

  @Override
  public AdminPermission save(AdminPermission baseObject) {
    return adminPermissionRepository.save(baseObject);
  }

  @Override
  public Iterable<AdminPermission> findByIds(Iterable<Long> ids) {
    return null;
//    return adminPermissionRepository.findAllById(ids);
  }

  @Override
  public List<AdminPermission> filter(String search, Long userId, int pageIndex, int pageSize) {
    return null;
//    return adminPermissionRepository.filter(search, userId, pageIndex, pageSize);
  }
}
