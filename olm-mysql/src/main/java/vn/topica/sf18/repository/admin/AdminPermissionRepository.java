package vn.topica.sf18.repository.admin;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.topica.sf18.model.admin.AdminPermission;

/**
 *
 */
public interface AdminPermissionRepository extends
    PagingAndSortingRepository<AdminPermission, Long>,
    JpaSpecificationExecutor<AdminPermission> {

}
