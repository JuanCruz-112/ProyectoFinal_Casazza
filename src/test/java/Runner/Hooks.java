package Runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Iniciando escenario: " + scenario.getName());

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("\n❌ FALLÓ: " + scenario.getName());
        } else {
            System.out.println("\n✅ PASÓ: " + scenario.getName());
        }
        System.out.println("========================================\n");

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
