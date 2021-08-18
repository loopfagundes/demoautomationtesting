package in.automationtesting.demo.steps;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.github.javafaker.Faker;
import in.automationtesting.demo.pageobjects.RegisterPageObject;
import in.automationtesting.demo.utils.Report;
import in.automationtesting.demo.utils.Screenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;

public class RegisterStep {
    private final WebDriver driver;
    private final RegisterPageObject registerPageObject;
    private Faker faker;
    private static final String FILE_UPDATE = System.getProperty("user.dir") + File.separator + "imagem" + File.separator + "java.jpg";

    public RegisterStep(WebDriver _driver) {
        driver = _driver;
        registerPageObject = new RegisterPageObject(_driver);
        faker = new Faker();
    }

    public RegisterStep indexPagina() {
        validacaoTituloDoSite();
        imagemDeUsuario();
        nomeDoUsuario();
        enderecoDoUsuario();
        emailDoUsuario();
        numeroDeTelefone();
        generoDeUsuario();
        hobbies();
        linguagens();
        return this;
    }

    private RegisterStep validacaoTituloDoSite() {
        Assert.assertEquals("Automation Demo Site", registerPageObject.validacaoTituloDeSiteLabel().getText());
        return this;
    }

    private RegisterStep imagemDeUsuario() {
        registerPageObject.imagemDeUsuarioButton().sendKeys(FILE_UPDATE);
        return this;
    }

    private RegisterStep nomeDoUsuario() {
        registerPageObject.primeiroNomeTextField().sendKeys(faker.name().firstName());
        registerPageObject.sobreNomeTextField().sendKeys(faker.name().lastName());
        return this;
    }

    private RegisterStep enderecoDoUsuario() {
        registerPageObject.enderecoTextField().sendKeys(faker.address().fullAddress());
        return this;
    }

    private RegisterStep emailDoUsuario() {
        registerPageObject.emailTextField().sendKeys(faker.internet().emailAddress());
        return this;
    }

    private RegisterStep numeroDeTelefone() {
        registerPageObject.numeroDeTelefoneTextField().sendKeys(faker.phoneNumber().phoneNumber());
        return this;
    }

    private RegisterStep generoDeUsuario() {
        registerPageObject.generoDeUsuarioCheckBox().click();
        return this;
    }

    private RegisterStep hobbies() {
        registerPageObject.hobbiesGriloCheckBox().click();
        registerPageObject.hobbiesFilmeCheckBox().click();
        registerPageObject.hobbiesHoqueiCheckBox().click();
        return this;
    }

    private RegisterStep linguagens() {
        registerPageObject.linguagensSelectComboBox().click();
        if(registerPageObject.selectLinguagem().isDisplayed()) {
            registerPageObject.selectLinguagem().click();
            ExtentTestManager.getTest().log(Status.PASS, "Selecionou uma linguagem.");
        } else {
            ExtentTestManager.getTest().log(Status.FAIL, "Nao selecionou...Deve ser BUG...", Screenshot.capture());
        }
        return this;
    }
}