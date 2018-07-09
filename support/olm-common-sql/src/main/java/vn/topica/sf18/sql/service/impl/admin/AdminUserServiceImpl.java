package vn.topica.sf18.sql.service.impl.admin;

import java.util.List;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.topica.sf18.generic.specification.GenericSpecificationsBuilder;
import vn.topica.sf18.generic.specification.SearchCriteria;
import vn.topica.sf18.model.admin.AdminUser;
import vn.topica.sf18.sql.repository.admin.AdminUserRepository;
import vn.topica.sf18.service.admin.AdminUserService;
import vn.topica.sf18.sql.specification.BaseSpecification;

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
  public AdminUser findById(Long id) {
    return adminUserRepository.findOne(id);
  }

  @Override
  public Iterable<AdminUser> findByIds(Iterable<Long> ids) {
    return adminUserRepository.findByIds(ids);
  }

  @Override
  public List<AdminUser> filter(String search, String username, int pageIndex, int pageSize) {
    GenericSpecificationsBuilder<AdminUser> builder = new GenericSpecificationsBuilder<>();
    Function<SearchCriteria, Specification<AdminUser>> converter = BaseSpecification::new;
    Specification<AdminUser> spec = builder.build(converter, search);
    return adminUserRepository.findAll(spec, new PageRequest(pageIndex - 1, pageSize)).getContent();
  }
}
