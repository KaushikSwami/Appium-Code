import BaseClass.BaseTest;
import org.testng.annotations.Test;
import pageObjectsDesign.Page1;

public class TestCase003 extends BaseTest {
    @Test(priority = 3)
    public void execute(){
        Page1 p1=new Page1(driver);
        p1.clickViewsButton().clickDragAndDrop().dragDropAndValidate();
    }
}
