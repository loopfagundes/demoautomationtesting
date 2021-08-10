package in.automationtesting.demo.steps;

import in.automationtesting.demo.pageobjects.RegisterPageObject;
import org.openqa.selenium.WebDriver;

public class RegisterStep {
    private final WebDriver driver;
    private final RegisterPageObject registerPageObject;

    public RegisterStep(WebDriver _driver) {
        driver = _driver;
        registerPageObject = new RegisterPageObject(_driver);
    }
}
