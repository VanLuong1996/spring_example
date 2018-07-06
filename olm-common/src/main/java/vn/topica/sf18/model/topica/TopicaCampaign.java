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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCampaign() {
    return campaign;
  }

  public void setCampaign(String campaign) {
    this.campaign = campaign;
  }

  public long getCampaignId() {
    return campaignId;
  }

  public void setCampaignId(long campaignId) {
    this.campaignId = campaignId;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public TopicaProduct getProduct() {
    return product;
  }

  public void setProduct(TopicaProduct product) {
    this.product = product;
  }

  public TopicaEstimator getEstimator() {
    return estimator;
  }

  public void setEstimator(TopicaEstimator estimator) {
    this.estimator = estimator;
  }

  public TopicaLegal getLegal() {
    return legal;
  }

  public void setLegal(TopicaLegal legal) {
    this.legal = legal;
  }

  public TopicaActivity getActivity() {
    return activity;
  }

  public void setActivity(TopicaActivity activity) {
    this.activity = activity;
  }
}
