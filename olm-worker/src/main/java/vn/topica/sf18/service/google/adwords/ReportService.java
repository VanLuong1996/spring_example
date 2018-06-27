package vn.topica.sf18.service.google.adwords;

import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.adwords.lib.client.reporting.ReportingConfiguration;
import com.google.api.ads.adwords.lib.factory.AdWordsServicesInterface;
import com.google.api.ads.adwords.lib.jaxb.v201806.DownloadFormat;
import com.google.api.ads.adwords.lib.jaxb.v201806.ReportDefinitionDateRangeType;
import com.google.api.ads.adwords.lib.jaxb.v201806.ReportDefinitionReportType;
import com.google.api.ads.adwords.lib.utils.ReportDownloadResponse;
import com.google.api.ads.adwords.lib.utils.ReportDownloadResponseException;
import com.google.api.ads.adwords.lib.utils.ReportException;
import com.google.api.ads.adwords.lib.utils.v201806.ReportDownloaderInterface;
import com.google.api.ads.adwords.lib.utils.v201806.ReportQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class ReportService {

    public void getReport(String reportFile, AdWordsServicesInterface adWordsService, AdWordsSession session)
            throws ReportDownloadResponseException, ReportException, IOException {

        // Create query.
        // Create query.
        ReportQuery query =
                new ReportQuery.Builder()
                        .fields(
                                "Date",
                                "Campaign",
                                "CampaignId",
                                "AccountCurrencyCode",
                                "Impressions",
                                "Clicks",
                                "Cost", //amount
                                "Month",
                                "Year")
                        .from(ReportDefinitionReportType.CRITERIA_PERFORMANCE_REPORT)
                        .where("Status").in("ENABLED", "PAUSED")
                        .during(ReportDefinitionDateRangeType.YESTERDAY)
                        .build();
//        ReportQuery query =
//                new ReportQuery.Builder()
//                        .fields(
//                                "CampaignId",
//                                "AdGroupId",
//                                "Id",
//                                "Criteria",
//                                "CriteriaType",
//                                "Impressions",
//                                "Clicks",
//                                "Cost")
//                        .from(ReportDefinitionReportType.CRITERIA_PERFORMANCE_REPORT)
//                        .where("Status").in("ENABLED", "PAUSED")
//                        .during(ReportDefinitionDateRangeType.YESTERDAY)
//                        .build();

        // Optional: Set the reporting configuration of the session to suppress header, column name, or
        // summary rows in the report output. You can also configure this via your ads.properties
        // configuration file. See AdWordsSession.Builder.from(Configuration) for details.
        // In addition, you can set whether you want to explicitly include or exclude zero impression
        // rows.
        ReportingConfiguration reportingConfiguration =
                new ReportingConfiguration.Builder()
                        .skipReportHeader(false)
                        .skipColumnHeader(false)
                        .skipReportSummary(false)
                        // Set to false to exclude rows with zero impressions.
                        .includeZeroImpressions(true)
                        .build();
        session.setReportingConfiguration(reportingConfiguration);

        ReportDownloaderInterface reportDownloader =
                adWordsService.getUtility(session, ReportDownloaderInterface.class);

        // Set the property api.adwords.reportDownloadTimeout or call
        // ReportDownloader.setReportDownloadTimeout to set a timeout (in milliseconds)
        // for CONNECT and READ in report downloads.
        ReportDownloadResponse response =
                reportDownloader.downloadReport(query.toString(), DownloadFormat.CSV);
        response.saveToFile(reportFile);

        log.info("Report successfully downloaded to: {}", reportFile);
    }
}
