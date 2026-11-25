package ar.org.icaro.automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private By campoUsuario = By.xpath("//input[@placeholder='Username']");
    private By campoContraseña = By.xpath("//input[@placeholder='Password']");
    private By btnLogin = By.xpath("//button[@type='submit']");
    private By msjError = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String actualPage() {
        return "login";
    }

    public void goTo () {
        driver.get(this.url);
    }

    public LoginPage enterUserName (String usuario) {
        click(campoUsuario);
        type(usuario, campoUsuario);
        return this;
    }

    public LoginPage enterPassword (String contraseña) {
        click(campoContraseña);
        type(contraseña, campoContraseña);
        return this;
    }

    public DashboardPage clickLogin(){
        click(btnLogin);
        return new DashboardPage(driver);
    }

    public DashboardPage loginAs (String usuario, String contraseña) {
        enterUserName(usuario).
        enterPassword(contraseña);
        return clickLogin();
    }

    public boolean isOnLoginPage () {
        return waitForUrlContains(actualPage());
    }

    public boolean isErrorDisplayed(String usuarioIncorrecto, String contraseñaIncorrecta) {
       boolean devolver = false;
        enterUserName(usuarioIncorrecto);
        enterPassword(contraseñaIncorrecta);
        click(btnLogin);
        devolver = isElementVisible(msjError);
        return  devolver;
    }




}
