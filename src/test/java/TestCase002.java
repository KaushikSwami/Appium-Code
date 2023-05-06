import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pageObjectsDesign.Page1;

public class TestCase002 extends BaseTest {
    @Test(priority = 1)
    public void execute(){
        Page1 p1=new Page1(driver);
        p1.clickViewsButton().scrollToWebview();
    }
}
