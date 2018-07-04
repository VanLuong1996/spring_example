package vn.topica.sf18.test.facebook;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.Campaign;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestFBJavaSDK {

  public static final APIContext context = new APIContext(
      "EAALGrsZCwK40BAKHKETlK38EKrr3nlzit0f6xlSRfTutb9aGkyK1VReZC1HAZB1s4zg6PJv1LRcdoXm7w6PjmnwM6SNLaVyTCbBWX5kB2dp6TKqxJj0pMxQITLywWKZBea6bWwjxPZAPVRBIcgCUwkk1ZCTqhjHXW1xZBPZAN3c0jIAxZA5oqlnyK",
      "5efbc5ec7c0f4cd4ebd2a95aaca8636f"
  );

  public static void main(String[] args) {
    AdAccount account = new AdAccount("888100887921887", context);
    try {
      APINodeList<Campaign> campaigns = account.getCampaigns().requestAllFields().execute();
      for (Campaign campaign : campaigns) {
        log.info("{}, {}, {}", campaign.getFieldId(), campaign.getFieldName(),
            campaign.getFieldDailyBudget());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
