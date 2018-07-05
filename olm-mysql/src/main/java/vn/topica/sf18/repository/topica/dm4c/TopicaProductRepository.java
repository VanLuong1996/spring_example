package vn.topica.sf18.repository.topica.dm4c;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.topica.sf18.model.topica.dm4c.TopicaProduct;

public interface TopicaProductRepository extends PagingAndSortingRepository<TopicaProduct, Long>,
    JpaSpecificationExecutor<TopicaProduct> {

}
