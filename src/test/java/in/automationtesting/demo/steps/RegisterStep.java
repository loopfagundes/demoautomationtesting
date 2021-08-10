package in.automationtesting.demo.steps;

import com.github.javafaker.Faker;
import in.automationtesting.demo.pageobjects.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterStep {
    private final WebDriver driver;
    private final RegisterPageObject registerPageObject;
    private Faker faker;

    public RegisterStep(WebDriver _driver) {
        driver = _driver;
        registerPageObject = new RegisterPageObject(_driver);
        faker = new Faker();
    }

    public RegisterStep indexPagina() {
        validacaoTituloDoSite();
        nomeDoUsuario();
        return this;
    }

    private RegisterStep validacaoTituloDoSite() {
        Assert.assertEquals("Automation Demo Site", registerPageObject.validacaoTituloDeSiteLabel().getText());
        return this;
    }

    private RegisterStep nomeDoUsuario() {
        registerPageObject.primeiroNomeTextField().sendKeys(faker.name().firstName());
        registerPageObject.sobreNomeTextField().sendKeys(faker.name().lastName());
        return this;
    }
}
