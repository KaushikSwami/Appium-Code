package pageObjectsDesign;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidActions;

import java.util.List;

public class Page3 extends AndroidActions {
   AndroidDriver driver;
    public Page3(AndroidDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//android.widget.TextView")
    private List<WebElement> expandableList;

    public void validateElement(){
        for(int i=0;i<expandableList.size();i++){
            String val=expandableList.get(i).getText();
            //System.out.println(val);
            if(val.equalsIgnoreCase("2. Cursor (People)")){
                Assert.assertEquals(val,"2. Cursor (People)");
            }
        }
    }
}
