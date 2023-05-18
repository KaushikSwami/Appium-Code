package BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;



public class BaseTest {
    public AndroidDriver driver;
    public Activity activity;
    public FileInputStream fis;
    public Properties prop;
    public String path;
    public ExtentSparkReporter reporter;
    public ExtentReports reports;

    @BeforeClass
    @Parameters({"PlatformName","UrlAppiumLink","udid"})
    public void launchApp(String PlatformName,String UrlAppiumLink,String udid) throws IOException {
        fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//config//config.properties");
        prop=new Properties();
        prop.load(fis);
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName(PlatformName);
        options.setUdid(udid);
        driver=new AndroidDriver(new URL(UrlAppiumLink),options);
        activity=new Activity(prop.getProperty("appPackage"),prop.getProperty("appActivity"));
        driver.startActivity(activity);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterClass
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
