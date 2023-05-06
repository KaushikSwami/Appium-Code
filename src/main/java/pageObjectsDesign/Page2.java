package pageObjectsDesign;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidActions;

public class Page2 extends AndroidActions {
    AndroidDriver driver;

    public Page2(AndroidDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Expandable Lists\"]")
    private WebElement expandableList;

    @FindBy(xpath="//android.widget.TextView[@content-desc='WebView']")
    private WebElement webview;

    public Page3 clickExpandable(){
        clickElement(expandableList);
        return new Page3(driver);
    }
    public void scrollToWebview(){
        scrollFromTopToDownUntilElementVisible(webview);
        Assert.assertEquals(true,webview.isDisplayed());
    }
}
