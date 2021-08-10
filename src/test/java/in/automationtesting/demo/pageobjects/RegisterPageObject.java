package in.automationtesting.demo.pageobjects;

import in.automationtesting.demo.utils.WaitElement;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject {
    private final WebDriver driver;
    private final WaitElement waitElement;

    public RegisterPageObject(WebDriver _driver) {
        driver = _driver;
        waitElement = new WaitElement(_driver);
    }
}