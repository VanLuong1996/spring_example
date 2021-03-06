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
import vn.topica.sf18.model.admin.AdminRole;
import vn.topica.sf18.sql.repository.admin.AdminRoleRepository;
import vn.topica.sf18.service.admin.AdminRoleService;
import vn.topica.sf18.sql.specification.BaseSpecification;

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
  public AdminRole findById(Long id) {
    return adminRoleRepository.findOne(id);
  }

  @Override
  public Iterable<AdminRole> findByIds(Iterable<Long> ids) {
    return adminRoleRepository.findByIds(ids);
  }

  @Override
  public List<AdminRole> filter(String search, String username, int pageIndex, int pageSize) {
    GenericSpecificationsBuilder<AdminRole> builder = new GenericSpecificationsBuilder<>();
    Function<SearchCriteria, Specification<AdminRole>> converter = BaseSpecification::new;
    Specification<AdminRole> spec = builder.build(converter, search);
    return adminRoleRepository.findAll(spec, new PageRequest(pageIndex - 1, pageSize)).getContent();
  }
}
