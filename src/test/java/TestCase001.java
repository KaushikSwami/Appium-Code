import io.qameta.allure.*;
import org.testng.annotations.Test;
import pageObjectsDesign.Page1;

public class TestCase001 extends BaseTest {
    @Test(priority = 0)
    public void execute(){
        Page1 p1=new Page1(driver);
        p1.clickViewsButton().clickExpandable().validateElement();
    }
}
