package in.automationtesting.demo.testcases;

import in.automationtesting.demo.steps.RegisterStep;
import in.automationtesting.demo.utils.BaseTest;
import in.automationtesting.demo.utils.Property;
import in.automationtesting.demo.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class RegistraTestCase extends BaseTest {

    @Test
    public void registraComSucessoTest() {
        WebDriver driver = DriverManager.getDriver();
        driver.get(Property.get("url"));
        RegisterStep registerStep = new RegisterStep(driver);
    }
}