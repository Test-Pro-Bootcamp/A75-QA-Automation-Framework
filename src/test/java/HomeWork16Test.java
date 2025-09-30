import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class HomeWork16Test extends BaseTest {

    @Test
    public void registrationNavigation() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            driver.get("https://qa.koel.app/");
            driver.findElement(By.partialLinkText("Registration")).click();

            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(
                    currentUrl.toLowerCase().contains("registration"),
                    "Expected registration page but got: " + currentUrl
            );
        }
        finally {
            driver.quit();
        }
    }
}
