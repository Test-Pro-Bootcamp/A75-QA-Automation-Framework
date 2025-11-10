package tests;

import io.github.bonigarcia.wdm.WebDriverManager; // only if you keep WDM
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;

    @Parameters("Url")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("https://qa.koel.app/") String baseUrl) {
        // If using WebDriverManager, keep this line; otherwise remove it.
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
