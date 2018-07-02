package vn.topica.sf18.model.admin;

import lombok.Data;

import java.util.Set;

@Data
public class AdminUser {

    private Long id;

    private String email;

    private String hashedPassword;

    private String username;

    private boolean isActive;


    private Set<AdminPermission> adminPermission;

    private Set<AdminRole> adminRole;


    public AdminUser(String username, String email, String hashedPassword) {
        this.username = username;
        this.email = email;
        this.hashedPassword = hashedPassword;
        isActive = true;
    }
}
