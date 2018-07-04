package vn.topica.sf18.model.admin;

import java.util.Set;
import lombok.Data;

/**
 * Created by ico on 10/9/17.
 */
@Data
public class AdminPermission {

  private Long id;

  private String name;


  private Set<AdminRole> adminRole;

  private Set<AdminUser> adminUser;


  public AdminPermission(String name) {
    this.name = name;
  }
}
