package ar.org.icaro.automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DashboardPage extends BasePage{

    private By btnPIM = By.xpath("//span[normalize-space()='PIM']");
    private By btnUser = By.xpath("//p[@class='oxd-userdropdown-name']");
    private By btnLogOut = By.xpath("//a[normalize-space()='Logout']");
    private By header = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String actualPage() {
        return "dashboard";
    }

    public PIMPage goToPim() {
        click(btnPIM);
        return new PIMPage(driver);
    }

    public void logout () {
        click(btnUser);
        click(btnLogOut);
    }

    public boolean isOnDashboard () {
        return waitForUrlContains(actualPage());
    }

    public String getHeaderText() {
        return getText(header);
    }















}
