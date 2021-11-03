package in.automationtesting.demo.pageobjects;

import in.automationtesting.demo.utils.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPageObject {
    private final WebDriver driver;
    private final WaitElement waitElement;

    public RegisterPageObject(WebDriver _driver) {
        driver = _driver;
        waitElement = new WaitElement(_driver);
    }

    public WebElement validacaoTituloDeSiteLabel() {
        return waitElement.visibilityOf(By.cssSelector("header[id='header'] div[class='row'] h1"));
    }

    public WebElement imagemDeUsuarioButton() {
        return waitElement.toBeClickable(By.id("imagesrc"));
    }

    public WebElement primeiroNomeTextField() {
        return waitElement.toBeClickable(By.cssSelector("input[placeholder='First Name']"));
    }

    public WebElement sobreNomeTextField() {
        return waitElement.toBeClickable(By.cssSelector("input[placeholder='Last Name']"));
    }

    public WebElement enderecoTextField() {
        return waitElement.toBeClickable(By.cssSelector("#basicBootstrapForm > div:nth-child(2) > div > textarea"));
    }

    public WebElement emailTextField() {
        return waitElement.toBeClickable(By.cssSelector("#eid > input"));
    }

    public WebElement numeroDeTelefoneTextField() {
        return waitElement.toBeClickable(By.cssSelector("#basicBootstrapForm > div:nth-child(4) > div > input"));
    }

    public WebElement generoDeUsuarioCheckBox() {
        return waitElement.toBeClickable(By.cssSelector("#basicBootstrapForm > div:nth-child(5) > div > label:nth-child(1) > input"));
    }

    public WebElement hobbiesGriloCheckBox() {
        return waitElement.toBeClickable(By.id("checkbox1"));
    }

    public WebElement hobbiesFilmeCheckBox() {
        return waitElement.toBeClickable(By.id("checkbox2"));
    }

    public WebElement hobbiesHoqueiCheckBox() {
        return waitElement.toBeClickable(By.id("checkbox3"));
    }

    public WebElement linguagensSelectComboBox() {
        return waitElement.toBeClickable(By.id("msdd"));
    }

    public WebElement selectLinguagem() {
        return waitElement.toBeClickable(By.cssSelector("#basicBootstrapForm > div:nth-child(7) > div > multi-select > div:nth-child(2) > ul > li:nth-child(29) > a"));
    }

    public Select skillsComboBox() {
        return new Select(waitElement.toBeClickable(By.id("Skills")));
    }

    public WebElement selectCountryComboBox() {
        return waitElement.toBeClickable(By.cssSelector("#basicBootstrapForm > div:nth-child(10) > div > span > span.selection > span"));
    }
}