package vn.topica.sf18.model.admin;

import java.util.Set;
import lombok.Data;

@Data
public class AdminRole {

  private Long id;

  private String name;


  private Set<AdminPermission> adminPermission;

  private Set<AdminUser> adminUser;


  public AdminRole(String name) {
    this.name = name;
  }
}
