package Steps;

import Runner.Hooks;
import ar.org.icaro.automatizacion.DashboardPage;
import ar.org.icaro.automatizacion.LoginPage;
import ar.org.icaro.automatizacion.PIMPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FlujoPrincipalSteps {

    private LoginPage login;
    private DashboardPage dashboard;
    private PIMPage pim;


    @Given("estoy logueado")
    public void estoyLogueado() {
        login = new LoginPage(Hooks.driver);
        login.goTo();
        dashboard = login.loginAs("Admin", "admin123");
    }

    @When("navego a la sección PIM")
    public void navegoALaSeccionPIM() {
        pim = dashboard.goToPim();
    }

    @And("hago click en Employee Name, escribo {string} e inicio la busqueda")
    public void hagoClickEnEmployeeNameEIngresoElNombre(String employeeName) {
        pim.searchEmployeeByName(employeeName);
    }


    @And("hago click en mi perfil de arriba a la derecha y selecciono Logout")
    public void hagoClickEnMiPerfilYSeleccionoLogout() {
        pim.logout();
    }

    @Then("deberia ver la página de login")
    public void deberiaVerLaPaginaDeLogin() {
        Assert.assertTrue(login.isOnLoginPage(), "Debería estar en la página de login después de cerrar sesión");
    }


}