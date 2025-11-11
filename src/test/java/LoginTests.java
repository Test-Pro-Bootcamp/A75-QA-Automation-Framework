import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;

import java.time.Duration;

public class LoginTests extends BaseTest {

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

        /*driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();*/
    }
    @Test
    public void loginValidEmailPassword() {
        String url = "https://qa.koel.app/";
        //pagefactory.LoginPage loginPage = new pagefactory.LoginPage(getDriver());
        //LoginPage loginPage = new LoginPage((getDriver()));
        pom.LoginPage loginPage = new pom.LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //pagefactory.HomePage homePage = new pagefactory.HomePage(getDriver());

        loginPage.provideEmail("felicia.clay@testpro.io");
                loginPage.providePassword("ACw0FWOe");
                loginPage.clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
        driver.quit();
       // Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        //loginPage.provideEmail("felicia.clay@testpro.io");
        //loginPage.providePassword("ACw0FWOe");
        //loginPage.clickSubmit();
        //Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        //WebElement avataricon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='avatar']")));
        //driver.quit();
    }

    @Test
    public void incorrectEmailCorrectPassword() throws InterruptedException {
        //opening URL
        String url = "https://qa.koel.app/";
        //LoginPage loginPage = new LoginPage(getDriver());
        pom.LoginPage loginPage = new pom.LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("incorrect@testpro.io");
        loginPage.providePassword("ACw0FWOe");
        loginPage.clickSubmit();
        //Thread.sleep(2000);

        //Expected Result
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
        getDriver().quit();
    }

    @Test(dataProvider = "IncorrectLoginData", dataProviderClass = DataProvid.class)
    public void incorrectDataTest(String email , String password) throws InterruptedException{

        provideEmail(email);
        providePassword(password);
        clickSubmitBtn();
        Thread.sleep(2000);

        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
}
