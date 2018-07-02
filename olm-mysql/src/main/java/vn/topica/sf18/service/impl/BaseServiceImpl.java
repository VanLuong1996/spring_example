package vn.topica.sf18.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.friend.common.spring.boot.generic.specification.GenericSpecificationsBuilder;
import net.friend.common.spring.boot.generic.specification.SearchCriteria;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import vn.topica.sf18.repository.BaseRepository;
import vn.topica.sf18.service.BaseService;
import vn.topica.sf18.specification.BaseSpecification;

import java.util.List;
import java.util.function.Function;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class BaseServiceImpl<T, X> implements BaseService<T, X> {

    private BaseRepository<T, X> baseRepository;

    @Override
    public T save(T baseObject) {
        return baseRepository.save(baseObject);
    }

    @Override
    public List<T> findByIds(Long[] ids) {
        return baseRepository.findByIds(ids);
    }

    @Override
    public List<T> filter(String search, Long userId, int pageIndex, int pageSize) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        Function<SearchCriteria, Specification<T>> converter = BaseSpecification::new;
        Specification<T> spec = builder.build(converter, search);
        return baseRepository.findAll(spec, PageRequest.of(pageIndex - 1, pageSize)).getContent();
    }
}
