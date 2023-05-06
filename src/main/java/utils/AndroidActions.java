package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AndroidActions {
    AppiumDriver driver;
    public AndroidActions(AppiumDriver driver){
        this.driver= driver;
    }
    public boolean clickElement(WebElement ele){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            ele.click();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public void sendKeysValue(WebElement ele, String data){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.clear();
        ele.sendKeys(data);
    }
    private boolean eleIsDisplayed(WebElement ele) {
        try {
            if (ele.isDisplayed())
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    public void androidScrollDown(){
        try{
            boolean canScrollMore  = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 600, "height", 600,
                    "direction", "down",
                    "percent", 3.0));
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }
    public boolean scrollFromTopToDownUntilElementVisible(WebElement ele){
        while (!eleIsDisplayed(ele)) {
            androidScrollDown();
        }
        return true;
    }
}
