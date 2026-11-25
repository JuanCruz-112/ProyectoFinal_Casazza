package ar.org.icaro.automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage extends BasePage{

    private By campoNombre = By.xpath("//input[@placeholder='Type for hints...']");
    private By btnSearch = By.xpath("//button[@type='submit']");
    private By msjNoResultados = By.xpath("//span[normalize-space()='No Records Found']");
    private By btnUser = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
    private By btnLogOut = By.xpath("//a[normalize-space()='Logout']");

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String actualPage() {
        return "pim";
    }

    public void ingresarNombreEmpleado(String nombre) {
        click(campoNombre);
        type(nombre, campoNombre);
    }

    public void searchEmployeeByName (String nombre) {
        ingresarNombreEmpleado(nombre);
        click(btnSearch);
    }

    public void logout () {
        click(btnUser);
        click(btnLogOut);
    }

    public boolean hasResults() {
        return waitForElementToDisappear(msjNoResultados);
    }


    public boolean isOnPIMPage() {
        return waitForUrlContains(actualPage());
    }

}
