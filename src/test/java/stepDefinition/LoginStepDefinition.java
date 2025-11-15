package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
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
import pom.*;

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

    @And("I open Home Page")
    public void iOpenHomePage() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://qa.koel.app/#!/home");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //throw new PendingException();
    }

    @And("I open Current Queue Page")
    public void iOpenCurrentQueuePage() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://qa.koel.app/#!/queue");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //throw new PendingException();
    }

    @And("I open All Songs Page")
    public void iOpenAllSongsPage() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://qa.koel.app/#!/songs");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //throw new PendingException();
    }

    @And("I open Albums Page")
    public void iOpenAlbumsPage() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://qa.koel.app/#!/albums");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //throw new PendingException();
    }

    @And("I open Artists Page")
    public void iOpenArtistsPage() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://qa.koel.app/#!/artists");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //throw new PendingException();
    }

    @And("I open Favorites Page")
    public void iOpenFavoritesPage() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://qa.koel.app/#!/favorites");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //throw new PendingException();
    }

    @And("I open Recently Played Page")
    public void iOpenRecentlyPlayedPage() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://qa.koel.app/#!/recently-played");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //throw new PendingException();
    }

    @And("I open User created playlist")
    public void iOpenUserCreatedPlaylist() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://qa.koel.app/#!/playlist/106021");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //throw new PendingException();
    }
    @And("I open Profile page")
    public void iOpenProfilePage() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://qa.koel.app/#!/profile");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @And("I enter current password {string}")
    public void iEnterCurrentPassword(String currentpassword) {
        // Write code here that turns the phrase above into concrete actions;
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.providePwd(currentpassword);
    }

    @And("I enter new password {string}")
    public void iEnterNewPassword(String newpassword) {
        // Write code here that turns the phrase above into concrete actions
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.provideNewPwd(newpassword);
    }

    @And("I Save")
    public void iSave() {
        // Write code here that turns the phrase above into concrete actions
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickSave();
    }

    /*@After
    public void closeBrowser(){
        driver.quit();
    }*/

    @Then("I am logged in")
    public void iAmLoggedIn() {
        HomePage homePage = new HomePage(driver);
        //homePage.getUserAvatar();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        //Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }

    @Then("Profile has been updated")
    public void profileHasBeenUpdated() {
        // Write code here that turns the phrase above into concrete actions
        ProfilePage profilePage = new ProfilePage(driver);
        //profilePage.getProfileUpdatedMsg();
        Assert.assertTrue(profilePage.getProfileUpdatedMsg().contains("Profile & Preferences"));
        //throw new PendingException();
    }

    @Then("Home Page is displayed")
    public void homePageIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        //homePage.getHomeName();
        Assert.assertTrue(homePage.getHomeName().contains("Felicia"));
        // throw new PendingException();
    }

    @Then("Current Queue is displayed")
    public void currentQueueIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        CurrentQPage currentQPage = new CurrentQPage(driver);
        //currentQPage.getCurrentQMsg();
        Assert.assertTrue(currentQPage.getCurrentQMsg().contains("Current Queue"));
        //throw new PendingException();
    }

    @Then("All Songs Page displayed")
    public void allSongsPageDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        //allSongsPage.getallSongsMsg();
        Assert.assertTrue(allSongsPage.getallSongsMsg().contains("All Songs"));
        //throw new PendingException();
    }

    @Then("All Albums are displayed")
    public void allAlbumsAreDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        AlbumsPage albumsPage = new AlbumsPage(driver);
        //albumsPage.getAlbumsMsg();
        Assert.assertTrue(albumsPage.getAlbumsMsg().contains("Albums"));
        //throw new PendingException();
    }

    @Then("Artists Page is displayed")
    public void artistsPageIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        ArtistsPage artistsPage = new ArtistsPage(driver);
        //artistsPage.getArtistsMsg();
        Assert.assertTrue(artistsPage.getArtistsMsg().contains("Artists"));
        //throw new PendingException();
    }

    @Then("Favorites Page is displayed")
    public void favoritesPageIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        //favoritesPage.getFavoritesMsg();
        Assert.assertTrue(favoritesPage.getFavoritesMsg().contains("Songs You Love"));
        //throw new PendingException();
    }

    @Then("Recently Played is displayed")
    public void recentlyPlayedIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        RecentlyPlayedPage recentlyPlayedPage = new RecentlyPlayedPage(driver);
        //recentlyPlayedPage.getRecentlyPlayedMsg();
        Assert.assertTrue(recentlyPlayedPage.getRecentlyPlayedMsg().contains("Recently Played"));
        //throw new PendingException();
    }

    @Then("User Playlist is displayed")
    public void userPlaylistIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        UserPlaylistPage userPlaylistPage = new UserPlaylistPage(driver);
        Assert.assertTrue(userPlaylistPage.getUserPlaylistMsg().contains("Test Pro Playlist"));
        //throw new PendingException();
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }


}
