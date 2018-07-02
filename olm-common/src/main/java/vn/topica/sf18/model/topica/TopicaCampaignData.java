package vn.topica.sf18.model.topica;

import lombok.Data;

@Data
public class TopicaCampaignData extends BaseTopicaCampaignData {

    private Long id;

    private String source;

    private long campaignId;

    private String campaign;

    private String account;

    private long accountId;

    private int dateMonth;

    private int dateYear;

    private String sp;

    private String cdt;

    private String pt;

    private String hd;
}
