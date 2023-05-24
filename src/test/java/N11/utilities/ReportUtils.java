package N11.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportUtils {
    public static ExtentReports extentReports;
    public static ExtentHtmlReporter extentHtmlReporter;
    public static ExtentTest extentTest;
    public static String message;
    public static void createReport() {
        if (extentReports == null) {
            String reportName = "U19_html";
            String filePath = System.getProperty("user.dir")+"/TestOutput/Reports/"+reportName+"_report.html";
            extentHtmlReporter = new ExtentHtmlReporter(filePath);
            extentReports = new ExtentReports();
            extentReports.attachReporter(extentHtmlReporter);
            extentHtmlReporter.config().setDocumentTitle("TestNG Otomasyon Projesi Raporu");
            extentHtmlReporter.config().setAutoCreateRelativePathMedia(true);
            extentReports.setSystemInfo("Uygulama", "TestNG Projesi");
            extentReports.setSystemInfo("Test Türü", "Regression");
            extentReports.setSystemInfo("Grup", "Batch129");
            extentReports.setSystemInfo("Takım", "TEAM-9");
        }
    }
    public static void createTestReport(String testName, String summary) {
        String tester = summary.split("-")[1];
        String description = summary.split("-")[0];
        extentHtmlReporter.config().setReportName(testName);
        extentReports.setSystemInfo("User Story", testName);
        extentReports.setSystemInfo("QA", tester);
        extentTest = extentReports.createTest(testName, description);
    }
    public static void finishExtentReport() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
    public static void testInfo(String message) {
        if (extentTest != null) {
            extentTest.info(message);
        }
    }
    public static void testFail(String message) {
        if (extentTest != null) {
            extentTest.fail(message);
        }
    }
    public static void testPass(String message) {
        if (extentTest != null) {
            extentTest.pass(message);
        }
    }
    public static void addScreenShotToReport( String name) throws IOException {
        String path = ReusableMethods.tumSayfaResmi(name);
        ReportUtils.extentTest.info("<span style='color:green; font-weight:bold; font-size: 12px'>EKRAN GÖRÜNTÜSÜ ALINDI</span><br>(Resim Sayfanin sonuna eklenmistir. " +
                "Resmi büyütmek için üzerine tıklayınız.)"+
                ReportUtils.extentTest.addScreenCaptureFromPath(path));
    }


}