package pageObjectsDesign;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidActions;

public class Page2 extends AndroidActions {
//    AndroidDriver driver;

    public Page2(AppiumDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Expandable Lists\"]")
    private WebElement expandableList;

    @AndroidFindBy(xpath="//android.widget.TextView[@content-desc='WebView']")
    private WebElement webview;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Drag and Drop\"]")
    private WebElement dragAndDrop;

    public Page3 clickExpandable(){
        clickElement(expandableList);
        return new Page3(driver);
    }
    public void scrollToWebview(){
        scrollFromDownToTopUntilElementVisibleUsingPointerOptions(webview);
        //scrollFromDownToTopUntilElementVisibleUsingJavaScriptExecutor(webview);
        Assert.assertTrue(webview.isDisplayed());
    }
    public Page3 clickDragAndDrop(){
        clickElement(dragAndDrop);
        return new Page3(driver);
    }
}
