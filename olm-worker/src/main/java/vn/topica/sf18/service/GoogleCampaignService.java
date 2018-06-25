package vn.topica.sf18.service;

import com.google.api.ads.adwords.axis.factory.AdWordsServices;
import com.google.api.ads.adwords.axis.v201806.cm.Campaign;
import com.google.api.ads.adwords.axis.v201806.cm.CampaignPage;
import com.google.api.ads.adwords.axis.v201806.cm.CampaignServiceInterface;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.adwords.lib.factory.AdWordsServicesInterface;
import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.auth.OfflineCredentials.Api;
import com.google.api.ads.common.lib.conf.ConfigurationLoadException;
import com.google.api.ads.common.lib.exception.OAuthException;
import com.google.api.ads.common.lib.exception.ValidationException;
import com.google.api.client.auth.oauth2.Credential;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;

import static com.google.api.ads.common.lib.utils.Builder.DEFAULT_CONFIGURATION_FILENAME;

@Service
@Slf4j
public class GoogleCampaignService {

    private static final int PAGE_SIZE = 100;

    public AdWordsSession getAdWordsSession(){
        AdWordsSession session;
        try {
            // Generate a refreshable OAuth2 credential.
            Credential oAuth2Credential =
                    new OfflineCredentials.Builder()
                            .forApi(Api.ADWORDS)
                            .fromFile()
                            .build()
                            .generateCredential();

            // Construct an AdWordsSession.
            session = new AdWordsSession.Builder().fromFile().withOAuth2Credential(oAuth2Credential).build();
        } catch (ConfigurationLoadException cle) {
            System.err.printf(
                    "Failed to load configuration from the %s file. Exception: %s%n",
                    DEFAULT_CONFIGURATION_FILENAME, cle);
            return null;
        } catch (ValidationException ve) {
            System.err.printf(
                    "Invalid configuration in the %s file. Exception: %s%n",
                    DEFAULT_CONFIGURATION_FILENAME, ve);
            return null;
        } catch (OAuthException oe) {
            System.err.printf(
                    "Failed to create OAuth credentials. Check OAuth settings in the %s file. "
                            + "Exception: %s%n",
                    DEFAULT_CONFIGURATION_FILENAME, oe);
            return null;
        }

        return session;
    }

    public AdWordsServicesInterface getAdWordsService(){
        AdWordsServicesInterface adWordsServices = AdWordsServices.getInstance();
        return adWordsServices;
    }

    public void getAllCampaign(AdWordsServicesInterface adWordsServices, AdWordsSession session) throws RemoteException{
        // Get the CampaignService.
        CampaignServiceInterface campaignService =
                adWordsServices.get(session, CampaignServiceInterface.class);

        int offset = 0;

        String query = "SELECT Id, Name, Status ORDER BY Name";

        CampaignPage page = null;
        do {
            String pageQuery = query + String.format(" LIMIT %d, %d", offset, PAGE_SIZE);
            // Get all campaigns.
            page = campaignService.query(pageQuery);

            // Display campaigns.
            if (page.getEntries() != null) {
                for (Campaign campaign : page.getEntries()) {
                    System.out.printf("Campaign with name '%s' and ID %d was found.%n", campaign.getName(), campaign.getId());
                }
            } else {
                System.out.println("No campaigns were found.");
            }

            offset += PAGE_SIZE;
        } while (offset < page.getTotalNumEntries());
    }
}
