import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.BasePage;
import pagefactory.HomePage;
import pagefactory.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
public void loginValidEmailPassword(){
        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginpage.provideEmail("wiley.griffin@testpro.io")
                .providePassword("KUgY8Y1p")
                .clickSubmit();
    }

   @Test
    public void registrationVerification(){
        LoginPage loginPage = new LoginPage(getDriver());
        String regUrl = "https://qa.koel.app/registration";

        loginPage.clickReg();

        Assert.assertEquals(getDriver().getCurrentUrl(), regUrl);


    }
}
