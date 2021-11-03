package in.automationtesting.demo.utils;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import in.automationtesting.demo.webdrivers.BrowserEnum;
import in.automationtesting.demo.webdrivers.DriverFactory;
import in.automationtesting.demo.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerClassAdapter.class, Report.class})
public class BaseTest {

    @BeforeMethod
    public void setUp() {
        WebDriver driver = DriverFactory.createInstance(BrowserEnum.CHROME);
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        //DriverManager.quitDriver();
    }
}