package vn.topica.sf18;

import com.google.api.ads.adwords.axis.v201806.cm.Campaign;
import com.google.api.ads.adwords.axis.v201806.mcm.ManagedCustomer;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.adwords.lib.factory.AdWordsServicesInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import vn.topica.sf18.service.google.adwords.AccountService;
import vn.topica.sf18.service.google.adwords.AuthService;
import vn.topica.sf18.service.google.adwords.CampaignService;
import vn.topica.sf18.service.google.adwords.ReportService;

import java.util.List;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class Application implements CommandLineRunner {

    @Value("${app.report.folder}")
    private String reportFolder;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthService authService;

    @Autowired
    private CampaignService campaignService;

    @Autowired
    private ReportService reportService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Run application");

        AdWordsServicesInterface adWordsService = authService.getAdWordsService();
        AdWordsSession adWordsSession = authService.getAdWordsSession();

        List<ManagedCustomer> accounts = accountService.getAllAccounts(adWordsService, adWordsSession);
        log.info("Number of accounts {}", accounts.size());

        for(ManagedCustomer account: accounts){
            log.info("Account {} {}", account.getCustomerId(), account.getName());

            AdWordsSession adWordsAccountSession = authService.getAdWordsSession(Long.toString(account.getCustomerId()));
            reportService.getReport(reportFolder + account.getCustomerId() + ".csv", adWordsService, adWordsAccountSession);

//            List<Campaign> campaigns = campaignService.getAllCampaigns(adWordsService, adWordsAccountSession);
//            for(Campaign campaign: campaigns){
//                log.info("Campaign {}, {}, {}", campaign.getName(), campaign.getStartDate(), campaign.getEndDate());
//            }
        }
    }
}
