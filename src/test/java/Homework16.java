import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;

import java.time.Duration;

public class Homework16 extends BaseTest {
   @Test
    public  void  registrationPage(){
       //Preconditions
       LoginPage loginPage = new LoginPage(getDriver());
       String regUrl = "https://qa.koel.app/registration";

       //Test Steps
       loginPage.registration();

       //Expected Result
        Assert.assertEquals(getDriver().getCurrentUrl(), regUrl);

   }
}
