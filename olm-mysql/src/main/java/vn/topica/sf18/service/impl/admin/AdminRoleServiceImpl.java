package vn.topica.sf18.service.impl.admin;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.admin.AdminRole;
import vn.topica.sf18.repository.admin.AdminRoleRepository;
import vn.topica.sf18.service.admin.AdminRoleService;
import vn.topica.sf18.service.impl.BaseServiceImpl;

import java.util.List;

@AllArgsConstructor
//@Service
@Slf4j
public class AdminRoleServiceImpl extends BaseServiceImpl<AdminRole, Long> implements AdminRoleService {

    private AdminRoleRepository adminRoleRepository;

    @Override
    public AdminRole findByName(String name) {
        return adminRoleRepository.findByName(name);
    }

    @Override
    public List<AdminRole> findRolesByUsername(String username) {
        return adminRoleRepository.findRolesByUsername(username);
    }
}
