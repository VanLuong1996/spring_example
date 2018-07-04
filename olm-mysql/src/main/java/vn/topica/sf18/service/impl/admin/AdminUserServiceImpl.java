package vn.topica.sf18.service.impl.admin;

import java.util.List;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.friend.common.spring.boot.generic.specification.GenericSpecificationsBuilder;
import net.friend.common.spring.boot.generic.specification.SearchCriteria;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.admin.AdminUser;
import vn.topica.sf18.repository.admin.AdminUserRepository;
import vn.topica.sf18.service.admin.AdminUserService;
import vn.topica.sf18.specification.BaseSpecification;

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
  public List<AdminUser> findByIds(Long[] ids) {
    return adminUserRepository.findByIds(ids);
  }

  @Override
  public List<AdminUser> filter(String search, Long userId, int pageIndex, int pageSize) {
    GenericSpecificationsBuilder<AdminUser> builder = new GenericSpecificationsBuilder<>();
    Function<SearchCriteria, Specification<AdminUser>> converter = BaseSpecification::new;
    Specification<AdminUser> spec = builder.build(converter, search);
    return adminUserRepository.findAll(spec, new PageRequest(pageIndex - 1, pageSize))
        .getContent();
  }
}
