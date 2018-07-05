package vn.topica.sf18.service.impl.admin;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.friend.common.spring.boot.generic.specification.GenericSpecificationsBuilder;
import net.friend.common.spring.boot.generic.specification.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.admin.AdminPermission;
import vn.topica.sf18.repository.admin.AdminPermissionRepository;
import vn.topica.sf18.service.admin.AdminPermissionService;
import vn.topica.sf18.specification.BaseSpecification;

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
