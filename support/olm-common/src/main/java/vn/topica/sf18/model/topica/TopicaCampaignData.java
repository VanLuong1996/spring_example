package vn.topica.sf18.model.topica;

import lombok.Data;

@Data
public class TopicaCampaignData {

  private Long id;

  private String date;

  private String source;

  private String campaign;

  private long campaignId;

  private String account;

  private long accountId;

  private String currency;

  private long impressions;

  private long click;

  private long amount;

  private int dateMonth;

  private int dateYear;

  private String sp;

  private String cdt;

  private String pt;

  private String hd;
}
