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
import vn.topica.sf18.model.admin.AdminRole;
import vn.topica.sf18.repository.admin.AdminRoleRepository;
import vn.topica.sf18.service.admin.AdminRoleService;
import vn.topica.sf18.specification.BaseSpecification;

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
    return adminRoleRepository.findAllById(ids);
  }

  @Override
  public List<AdminRole> filter(String search, Long userId, int pageIndex, int pageSize) {
    return adminRoleRepository.filter(search, userId, pageIndex, pageSize);
  }
}
