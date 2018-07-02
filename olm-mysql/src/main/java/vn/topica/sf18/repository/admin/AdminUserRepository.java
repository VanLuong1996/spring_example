package vn.topica.sf18.repository.admin;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.topica.sf18.model.admin.AdminUser;

import java.util.List;

/**
 * Created by ico on 10/9/17.
 */
public interface AdminUserRepository extends PagingAndSortingRepository<AdminUser, Long>,
        JpaSpecificationExecutor<AdminUser> {

    AdminUser findByEmail(String email);

    AdminUser findByUsername(String username);
}
