package vn.topica.sf18.sql.service.impl.admin;

import java.util.List;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.topica.sf18.generic.specification.GenericSpecificationsBuilder;
import vn.topica.sf18.generic.specification.SearchCriteria;
import vn.topica.sf18.model.admin.AdminPermission;
import vn.topica.sf18.sql.repository.admin.AdminPermissionRepository;
import vn.topica.sf18.service.admin.AdminPermissionService;
import vn.topica.sf18.sql.specification.BaseSpecification;

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
  public AdminPermission findById(Long id) {
    return adminPermissionRepository.findOne(id);
  }

  @Override
  public Iterable<AdminPermission> findByIds(Iterable<Long> ids) {
    return adminPermissionRepository.findByIds(ids);
  }

  @Override
  public List<AdminPermission> filter(String search, String username, int pageIndex, int pageSize) {
    GenericSpecificationsBuilder<AdminPermission> builder = new GenericSpecificationsBuilder<>();
    Function<SearchCriteria, Specification<AdminPermission>> converter = BaseSpecification::new;
    Specification<AdminPermission> spec = builder.build(converter, search);
    return adminPermissionRepository.findAll(spec, new PageRequest(pageIndex - 1, pageSize)).getContent();
  }
}
