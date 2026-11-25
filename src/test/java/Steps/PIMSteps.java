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

public class PIMSteps {

    private LoginPage login;
    private DashboardPage dashboard;
    private PIMPage pim;

    @Given("estoy logueado con credenciales validas")
    public void estoyLogueadoConCredencialesValidas() {
        login = new LoginPage(Hooks.driver);
        login.goTo();
        dashboard = login.loginAs("Admin", "admin123");
    }


    @When("navego a la sección de PIM")
    public void navegoALaSeccionPIM() {
        pim = dashboard.goToPim();
    }


    @And("hago click en Employee Name, ingreso el nombre del empleado {string} y genero la busqueda")
    public void hagoClickEnEmployeeNameEIngresoElNombre(String employeeName) {
        pim.searchEmployeeByName(employeeName);
    }

    @Then("deberia ver los resultados de busqueda que coincidan con el nombre")
    public void deberiaVerLosResultadosDeBusqueda() {
        Assert.assertTrue(pim.hasResults(), "Debería haber resultados para el nombre ingresado");
    }


}