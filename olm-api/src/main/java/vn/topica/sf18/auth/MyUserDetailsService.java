package vn.topica.sf18.auth;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import vn.topica.sf18.model.admin.AdminRole;
import vn.topica.sf18.model.admin.AdminUser;
import vn.topica.sf18.service.admin.AdminRoleService;
import vn.topica.sf18.service.admin.AdminUserService;

@Component
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  private AdminRoleService roleService;
  @Autowired
  private AdminUserService userService;

  @PostConstruct
  public void init() {
    log.info("finish init");
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    AdminUser user = userService.findByUsername(username);
    log.info("[loadUserByUsername]username:" + username + ", user:" + user);

    if (user == null) {
      throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));
    }

    List<GrantedAuthority> authorities = new ArrayList<>();
    List<AdminRole> roles = roleService.findRolesByUsername(username);
    for (AdminRole role : roles) {
      authorities.add(new SimpleGrantedAuthority(role.getName()));
    }

    return new org.springframework.security.core.userdetails.User(user.getId().toString(),
        user.getHashedPassword(), authorities);
  }
}
