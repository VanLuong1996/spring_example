package vn.topica.sf18.service.topica;

import vn.topica.sf18.model.topica.TopicaCampaign;

import java.util.List;

public interface TopicaCampaignService {

    TopicaCampaign save(TopicaCampaign baseObject);

    //region admin-on-rest
    List<TopicaCampaign> findByIds(Long[] ids);

    List<TopicaCampaign> filter(String search, Long userId, int pageIndex, int pageSize);
}
