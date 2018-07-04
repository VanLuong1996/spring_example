package vn.topica.sf18.service.topica;

import java.util.List;
import vn.topica.sf18.model.topica.TopicaCampaignData;
import vn.topica.sf18.service.BaseService;

public interface TopicaCampaignDataService extends BaseService<TopicaCampaignData> {

  TopicaCampaignData save(TopicaCampaignData baseObject);

  //region admin-on-rest
  List<TopicaCampaignData> findByIds(Long[] ids);

  List<TopicaCampaignData> filter(String search, Long userId, int pageIndex, int pageSize);

  TopicaCampaignData getCampaignDataInfo(Long campaignId);

  //import file
  List<TopicaCampaignData> importFile(Long fileId);

  //update lai du lieu import
  List<TopicaCampaignData> updateImportedFile(Long fileId);

  //map campaignId & "hoat dong", "san pham", "chu du toan", "phap nhan"
  TopicaCampaignData mappingCampaignToStakeholders(Long campaignId,
      String sp, String cdt, String pt, String hd);
}
