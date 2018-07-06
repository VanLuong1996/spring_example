package vn.topica.sf18.service.topica;

import vn.topica.sf18.model.topica.TopicaCampaign;
import vn.topica.sf18.service.BaseService;

import java.util.List;
import vn.topica.sf18.model.topica.dm4c.TopicaActivity;
import vn.topica.sf18.model.topica.dm4c.TopicaEstimator;
import vn.topica.sf18.model.topica.dm4c.TopicaLegal;
import vn.topica.sf18.model.topica.dm4c.TopicaProduct;

public interface TopicaCampaignService extends BaseService<TopicaCampaign, Long> {

  //get campaign by campaign id
  TopicaCampaign findById(long id);

  //mapping campaign
  void update(List<TopicaCampaign> campaigns);

  //save campaign from file
  void extract(long fileId);

  List<TopicaCampaign> report(long fromDate, long toDate);

}
