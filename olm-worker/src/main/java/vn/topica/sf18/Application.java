package vn.topica.sf18;

import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.adwords.lib.factory.AdWordsServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import vn.topica.sf18.service.GoogleCampaignService;

@SpringBootApplication
@EnableScheduling
public class Application implements CommandLineRunner {

    @Autowired
    private GoogleCampaignService googleCampaignService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {
        AdWordsSession adWordsSession = googleCampaignService.getAdWordsSession();
        AdWordsServicesInterface adWordsService = googleCampaignService.getAdWordsService();
        googleCampaignService.getAllCampaign(adWordsService, adWordsSession);
    }
}
