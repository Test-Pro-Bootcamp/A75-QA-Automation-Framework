import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // TODO (for students): Review the configuration as part of HW15

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
    @Test
    public void incorrectEmailCorrectPassword() throws InterruptedException {
        //opening URL
        provideEmail("incorrect@testpro.io");
        providePassword("ACw0FWOe");
        clickSubmitBtn();
        Thread.sleep(2000);

        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void incorrectDataTest(String email , String password) throws InterruptedException{

        provideEmail(email);
        providePassword(password);
        clickSubmitBtn();
        Thread.sleep(2000);

        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
}
