package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExtentReporterNG {
    public static FileInputStream fis;
    public static Properties prop;
    public static String path;
    public static ExtentSparkReporter reporter;
    public static ExtentReports reports;

    public static ExtentReports getReporterObject() throws IOException {
        prop = new Properties();
        prop.load(fis);
        path = System.getProperty("user.dir") + "\\reports\\index.html";
        reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Mobile Automation report");
        reporter.config().setDocumentTitle("Mobile automation test results");
        reports = new ExtentReports();
        reports.attachReporter(reporter);
        reports.setSystemInfo("Tester name", prop.getProperty("testerName"));
        return reports;
    }
}
