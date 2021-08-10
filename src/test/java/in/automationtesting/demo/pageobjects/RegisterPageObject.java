package in.automationtesting.demo.pageobjects;

import in.automationtesting.demo.utils.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPageObject {
    private final WebDriver driver;
    private final WaitElement waitElement;

    public RegisterPageObject(WebDriver _driver) {
        driver = _driver;
        waitElement = new WaitElement(_driver);
    }

    public WebElement validacaoTituloDeSiteLabel() {
        return waitElement.visibilityOf(By.cssSelector("#header > div > div > div > div.col-sm-8.col-xs-8.col-md-8 > h1"));
    }

    public WebElement primeiroNomeTextField() {
        return waitElement.toBeClickable(By.cssSelector("input[placeholder='First Name']"));
    }

    public WebElement sobreNomeTextField() {
        return waitElement.toBeClickable(By.cssSelector("input[placeholder='Last Name']"));
    }
}