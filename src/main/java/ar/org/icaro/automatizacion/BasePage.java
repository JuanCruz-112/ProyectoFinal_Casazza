package ar.org.icaro.automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void click (By localizador) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(localizador)).click();
    }

    public void type (String texto, By localizador) {
        WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
        elem.clear();
        elem.sendKeys(texto);
    }

    public String getText (By localizador) {
      return wait.until(ExpectedConditions.visibilityOfElementLocated(localizador)).getText();
    }

    public boolean isElementVisible(By localizador) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(localizador)).isDisplayed();
    }

    public boolean waitForUrlContains(String text){
        try {
            wait.until(ExpectedConditions.urlContains(text));
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }

    public boolean waitForElementToDisappear(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return true;
        }
        catch (TimeoutException e) {
            return false;
        }
    }

    protected abstract String actualPage();

}
