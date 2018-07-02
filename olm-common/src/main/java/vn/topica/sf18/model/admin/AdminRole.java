package vn.topica.sf18.model.admin;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Set;

@Data
@Entity
public class AdminRole {

    private Long id;

    private String name;


    private Set<AdminPermission> adminPermission;

    private Set<AdminUser> adminUser;


    public AdminRole(String name) {
        this.name = name;
    }
}
