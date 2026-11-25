package Steps;

import Runner.Hooks;
import ar.org.icaro.automatizacion.DashboardPage;
import ar.org.icaro.automatizacion.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    private LoginPage login;
    private DashboardPage dashboard;

    @Given("estoy en la pagina de inicio de sesion de OrangeHRM")
    public void estoyEnLaPaginaDeLogin() {
        login = new LoginPage(Hooks.driver);
        login.goTo();
    }

    @When("ingreso el usuario {string} e ingreso la contraseña {string}")
    public void ingresoElUsuarioYLaContraseña(String usuario, String contraseña) {
        login.enterUserName(usuario);
        login.enterPassword(contraseña);
    }

    @And("hago clic en el boton Login")
    public void hagoClicEnElBotonLogin() {
        dashboard = login.clickLogin();
    }

    @Then("debo ver el Dashboard")
        public void deboVerElDashboard() {
            Assert.assertTrue(dashboard.isOnDashboard(), "Debería haber iniciado sesión correctamente y estar en el Dashboard");
        }
    }