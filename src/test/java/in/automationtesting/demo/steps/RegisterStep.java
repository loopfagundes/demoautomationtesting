package in.automationtesting.demo.steps;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.github.javafaker.Faker;
import in.automationtesting.demo.pageobjects.RegisterPageObject;
import in.automationtesting.demo.utils.Screenshot;
import org.openqa.selenium.Keys;
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
        //linguagens(); --> BUG
        habilidades();
        selecionaPais();
        dataDeNascimento();
        senha();
        return this;
    }

    private RegisterStep validacaoTituloDoSite() {
        Assert.assertEquals("Automation Demo Site", registerPageObject.validacaoTituloDeSiteLabel().getText());
        return this;
    }

    private RegisterStep imagemDeUsuario() {
        registerPageObject.imagemDeUsuarioButton().sendKeys(FILE_UPDATE);
        registerPageObject.fechaNoAdsByGoogle().click();
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
        /**
         * O metodo de linguagens e aqui deve ser bug.
         */
        registerPageObject.linguagensComboBox().click();
        if (registerPageObject.selecionaLinguagem().isDisplayed()) {
            registerPageObject.selecionaLinguagem().click();
            ExtentTestManager.getTest().log(Status.PASS, "Selecionou uma linguagem.");
        } else {
            ExtentTestManager.getTest().log(Status.FAIL, "Nao selecionou...Deve ser BUG...", Screenshot.capture());
        }
        return this;
    }

    private RegisterStep habilidades() {
        registerPageObject.habilidadesComboBox().selectByValue("Java");
        return this;
    }

    private RegisterStep selecionaPais() {
        registerPageObject.selecionaPaisComboBox().click();
        registerPageObject.buscaPaisTextField().sendKeys("Japan");
        registerPageObject.buscaPaisTextField().sendKeys(Keys.ENTER);
        return this;
    }

    private RegisterStep dataDeNascimento() {
        registerPageObject.anoDeNascimentoComboBox().selectByValue("1991");
        registerPageObject.mesDeNascimentoComboBox().selectByValue("May");
        registerPageObject.diaDeNascimentoComboBox().selectByValue("13");
        return this;
    }

    private RegisterStep senha() {
        String chaveSenha;
        chaveSenha = faker.internet().password();
        registerPageObject.senhaTextField().sendKeys(chaveSenha);
        registerPageObject.confirmaSenhatextField().sendKeys(chaveSenha);
        if (registerPageObject.enviaButton().isDisplayed()) {
            registerPageObject.enviaButton().click();
            ExtentTestManager.getTest().log(Status.PASS, "O botao recebe um clique. ");
        } else {
            ExtentTestManager.getTest().log(Status.FAIL, "Falhou de registrar.", Screenshot.capture());
        }
        return this;
    }
}