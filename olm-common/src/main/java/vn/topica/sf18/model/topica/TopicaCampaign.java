package vn.topica.sf18.model.topica;

import lombok.Data;
import vn.topica.sf18.model.topica.dm4c.TopicaActivity;
import vn.topica.sf18.model.topica.dm4c.TopicaEstimator;
import vn.topica.sf18.model.topica.dm4c.TopicaLegal;
import vn.topica.sf18.model.topica.dm4c.TopicaProduct;

@Data
public class TopicaCampaign {

    private Long id;

    private String campaign;

    private long campaignId;

    private String account;

    private String accountId;

    private String source;

    private TopicaProduct product;

    private TopicaEstimator estimator;

    private TopicaLegal legal;

    private TopicaActivity activity;
}
