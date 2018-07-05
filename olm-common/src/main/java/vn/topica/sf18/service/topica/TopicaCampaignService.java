package vn.topica.sf18.service.topica;

import vn.topica.sf18.model.topica.TopicaCampaign;
import vn.topica.sf18.service.BaseService;

import java.util.List;
import vn.topica.sf18.model.topica.dm4c.TopicaActivity;
import vn.topica.sf18.model.topica.dm4c.TopicaEstimator;
import vn.topica.sf18.model.topica.dm4c.TopicaLegal;
import vn.topica.sf18.model.topica.dm4c.TopicaProduct;

public interface TopicaCampaignService extends BaseService<TopicaCampaign, Long> {

  TopicaCampaign save(TopicaCampaign campaign);

  TopicaCampaign findById(Long id);

  //import file
  List<TopicaCampaign> findCampaignByImportId(Long fileId);

  //update lai du lieu import
  List<TopicaCampaign> updateImportedFile(Long fileId);

  //map campaignId & "hoat dong", "san pham", "chu du toan", "phap nhan"
  TopicaCampaign mappingCampaignToStakeholders(Long campaignId,
      TopicaProduct topicaProduct, TopicaActivity topicaActivity, TopicaLegal legal,
      TopicaEstimator topicaEstimator);

  void importCampaign(Long importId);
}
