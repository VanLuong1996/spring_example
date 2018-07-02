package vn.topica.sf18.model.admin;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Set;

/**
 * Created by ico on 10/9/17.
 */
@Data
@Entity
public class AdminPermission {

    private Long id;

    private String name;


    private Set<AdminRole> adminRole;

    private Set<AdminUser> adminUser;


    public AdminPermission(String name) {
        this.name = name;
    }
}
