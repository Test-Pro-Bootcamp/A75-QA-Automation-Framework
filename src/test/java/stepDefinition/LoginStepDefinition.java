package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pom.HomePage;
import pom.LoginPage;

import java.time.Duration;

public class LoginStepDefinition {

    WebDriver driver;
    WebDriverWait wait;


    @Given("I open browser")
    //@Before
    public void openBrowser(){
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disabled-notification");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("I open Login page")
    public void iOpenLoginPage() {
        driver.get("https://qa.koel.app");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);

       /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type]='email']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type]='email']"))).sendKeys(email);*/
    }

    @And("I enter password {string}")
    public void ienterpassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @And("I submit")
    public void iSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmit();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type]='submit']"))).click();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        HomePage homePage = new HomePage(driver);
        homePage.getUserAvatar();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        //Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
