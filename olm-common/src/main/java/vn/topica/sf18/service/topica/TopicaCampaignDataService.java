package vn.topica.sf18.service.topica;

import java.util.List;
import vn.topica.sf18.model.topica.TopicaCampaign;
import vn.topica.sf18.model.topica.TopicaCampaignData;
import vn.topica.sf18.service.BaseService;

public interface TopicaCampaignDataService extends BaseService<TopicaCampaignData, Long> {

  //get campaign by campaign id
  TopicaCampaign findById(long id);

  TopicaCampaignData getCampaignDataInfo(Long campaignId);

  //mapping campaign
  void update(List<TopicaCampaign> campaigns);

  //save campaign from file
  void extract(long fileId);

  List<TopicaCampaign> report(long fromDate, long toDate);

}
