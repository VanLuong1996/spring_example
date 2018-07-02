package vn.topica.sf18.service.topica;

import vn.topica.sf18.model.topica.TopicaCampaignData;

import java.util.List;

public interface TopicaCampaignDataService {

    TopicaCampaignData save(TopicaCampaignData baseObject);

    //region admin-on-rest
    List<TopicaCampaignData> findByIds(Long[] ids);

    List<TopicaCampaignData> filter(String search, Long userId, int pageIndex, int pageSize);
}
