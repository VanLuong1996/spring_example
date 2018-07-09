package vn.topica.sf18.service;

import vn.topica.sf18.model.topica.TopicaCampaign;
import vn.topica.sf18.model.topica.TopicaImport;

public interface CommonService {

  void processCampaign(TopicaCampaign topicaCampaign);

  void processImport(TopicaImport topicaImport);
}
