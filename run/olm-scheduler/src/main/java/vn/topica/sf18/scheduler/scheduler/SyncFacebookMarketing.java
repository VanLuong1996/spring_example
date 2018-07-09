package vn.topica.sf18.scheduler.scheduler;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.APIRequest;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdsInsights;
import com.facebook.ads.sdk.Campaign;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SyncFacebookMarketing {

  @Value("${api.facebookAds.accessToken}")
  private String accessToken;

  @Value("${api.facebookAds.appSecret}")
  private String appSecret;

  @Value("${api.facebookAds.enableDebug}")
  private Boolean enableDebug;

  private APIContext context;

  @PostConstruct
  public void init() {
    context = new APIContext(accessToken, appSecret).enableDebug(enableDebug);
  }

  @Scheduled(cron = "${app.scheduler.sync.facebookAds}")
  public void syncData() {
    try {
      APIRequest<AdAccount> request = new APIRequest<AdAccount>(context, "me", "/adaccounts", "GET",
          AdAccount.getParser());

      int accountPageIndex = 1;
      APINodeList<AdAccount> accounts = (APINodeList<AdAccount>) (request.execute());
      while (accounts != null) {
        log.info("page {}, accounts {}", accountPageIndex, accounts.size());
        for (AdAccount adAccount : accounts) {
          log.info("adAccount {}", adAccount);

//          exploreAccount(adAccount);
        }

        accounts = accounts.nextPage();
        ++accountPageIndex;
      }
    } catch (Exception ex) {
      log.error(ExceptionUtils.getFullStackTrace(ex));
    }
  }

  private void exploreAccount(AdAccount adAccount) throws APIException {
    APINodeList<Campaign> campaigns = adAccount.getCampaigns().requestAllFields().execute();
    while (campaigns != null) {
      for (Campaign campaign : campaigns) {
        log.info("campaign {}", campaign);
      }

      campaigns = campaigns.nextPage();
    }
  }

  private void exploreCampaign(Campaign campaign) throws APIException {
    APINodeList<AdsInsights> adsInsights = campaign.getInsights().requestAllFields().execute();
    while (adsInsights != null) {
      for (AdsInsights adsInsight : adsInsights) {
        log.info("adsInsight {}", adsInsight);
      }

      adsInsights = adsInsights.nextPage();
    }
  }
}
