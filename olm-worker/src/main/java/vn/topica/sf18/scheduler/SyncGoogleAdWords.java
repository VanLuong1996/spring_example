package vn.topica.sf18.scheduler;

import com.google.api.ads.adwords.axis.v201806.mcm.ManagedCustomer;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.adwords.lib.factory.AdWordsServicesInterface;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import vn.topica.sf18.service.google.adwords.AccountService;
import vn.topica.sf18.service.google.adwords.AuthService;
import vn.topica.sf18.service.google.adwords.ReportService;

import java.util.List;

@Service
@Slf4j
public class SyncGoogleAdWords {

    @Value("${app.report.folder}")
    private String reportFolder;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthService authService;

    @Autowired
    private ReportService reportService;

    @Scheduled(cron = "${app.scheduler.sync.googleAdWords}")
    public void syncData() {
        try{
            AdWordsServicesInterface adWordsService = authService.getAdWordsService();
            AdWordsSession adWordsSession = authService.getAdWordsSession();

            List<ManagedCustomer> accounts = accountService.getAllAccounts(adWordsService, adWordsSession);
            log.info("Number of accounts {}", accounts.size());

            for(ManagedCustomer account: accounts){
                log.info("Account {} {} {}", account.getCustomerId(), account.getName(), account.getCanManageClients());

                if(account.getCanManageClients()){
                    continue;
                }

                AdWordsSession adWordsAccountSession = authService.getAdWordsSession(Long.toString(account.getCustomerId()));
                reportService.getReport(reportFolder + account.getCustomerId() + ".csv", adWordsService, adWordsAccountSession);
            }
        }catch (Exception ex){
            log.error(ExceptionUtils.getFullStackTrace(ex));
        }
    }
}
