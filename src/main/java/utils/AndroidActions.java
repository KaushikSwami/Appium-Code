package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class AndroidActions {
    public AppiumDriver driver;
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
                return false;
        } catch (Exception e) {
            return true;
        }
        return true;
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
    public void scrollFromDownToUpInAppUsingPointerInput() {
        Dimension size = driver.manage().window().getSize();
        int x1 = (int) (size.getWidth() * 0.5);
        int y1 = (int) (size.getHeight() * 0.8);
        int x0 = (int) (size.getWidth() * 0.5);
        int y0 = (int) (size.getHeight() * 0.2);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x1, y1));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x0, y0));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }
    public void scrollFromDownToTopUntilElementVisibleUsingPointerOptions(WebElement ele){
        while (eleIsDisplayed(ele)) {
            scrollFromDownToUpInAppUsingPointerInput();
        }
    }
    public void scrollFromDownToTopUntilElementVisibleUsingJavaScriptExecutor(WebElement ele){
        while (eleIsDisplayed(ele)) {
            androidScrollDown();
        }
    }
    public void coordinatesLongClick(WebElement ele) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", 217,
                "y", 659,
                "duration", 1000));
    }
}
