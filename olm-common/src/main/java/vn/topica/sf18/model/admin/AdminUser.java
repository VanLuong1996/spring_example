package vn.topica.sf18.model.admin;

import java.util.Set;
import lombok.Data;

@Data
public class AdminUser {

  private Long id;

  private String username;

  private String hashedPassword;

  private boolean isActive;


  private Set<AdminPermission> adminPermission;

  private Set<AdminRole> adminRole;


  public AdminUser(String username, String hashedPassword) {
    this.username = username;
    this.hashedPassword = hashedPassword;
    isActive = true;
  }
}
