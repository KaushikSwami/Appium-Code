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

import java.util.List;

public class Page3 extends AndroidActions {
   //AndroidDriver driver;
    public Page3(AppiumDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "//android.widget.TextView")
    private List<WebElement> expandableList;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.view.View[1]")
    private WebElement dragDropElement;

    @AndroidFindBy(id="io.appium.android.apis:id/drag_result_text")
    private WebElement textValidations;
    public void validateElement(){
        for (WebElement webElement : expandableList) {
            String val = webElement.getText();
            //System.out.println(val);
            if (val.equalsIgnoreCase("2. Cursor (People)")) {
                Assert.assertEquals(val, "2. Cursor (People)");
            }
        }
    }
    public void dragDropAndValidate(){
        coordinatesLongClick(dragDropElement);
        //Assert.assertEquals(text,"drop");
    }
}
