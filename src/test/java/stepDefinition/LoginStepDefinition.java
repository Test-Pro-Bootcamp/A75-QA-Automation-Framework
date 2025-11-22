package stepDefinition;

import io.cucumber.java.After;
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
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type]='email']"))).clear();
        loginPage.provideEmail(email);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type]='email']"))).sendKeys(email);*/
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
        Assert.assertFalse(homePage.getHomeName().isBlank());
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


    @And("I Logout")
    public void iLogout() {
        // Write code here that turns the phrase above into concrete actions
        BasePage basePage = new BasePage(driver);
        basePage.clickLogout();
        //throw new PendingException();
    }

    @Then("Login Page is displayed")
    public void loginPageIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getLoginAvatar().isDisplayed());
        //throw new PendingException();
    }

    @And("I play Album")
    public void iPlayAlbum() {
        // Write code here that turns the phrase above into concrete actions
        AlbumsPage albumsPage = new AlbumsPage(driver);
        albumsPage.choose1stAlbum();
        //throw new PendingException();
    }

    @And("I play Artist")
    public void iPlayArtist() {
        // Write code here that turns the phrase above into concrete actions
        ArtistsPage artistsPage = new ArtistsPage(driver);
        artistsPage.choose1stArtist();
        //throw new PendingException();
    }

    @Then("Album is displayed")
    public void albumIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        CurrentQPage currentQPage = new CurrentQPage(driver);
        currentQPage.albumTab();
        currentQPage.getAlbumName();
        Assert.assertFalse(currentQPage.getAlbumName().isBlank());
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //throw new PendingException();
    }

    @Then("Lyrics is displayed")
    public void lyricsIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        CurrentQPage currentQPage = new CurrentQPage(driver);
        currentQPage.lyricsTab();
        currentQPage.getLyricsName();
        Assert.assertFalse(currentQPage.getLyricsName().isBlank());
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //throw new PendingException();
    }

    @Then("Artists is displayed")
    public void artistsIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        CurrentQPage currentQPage = new CurrentQPage(driver);
        currentQPage.ArtistsTab();
        currentQPage.getArtistName();
        Assert.assertFalse(currentQPage.getArtistName().isBlank());
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //throw new PendingException();
    }

    @And("I click Info Button")
    public void iClickInfoButton() {
        // Write code here that turns the phrase above into concrete actions
        CurrentQPage currentQPage = new CurrentQPage(driver);
        currentQPage.InfoBtn();
        //throw new PendingException();
    }

    @Then("Info Panel is displayed")
    public void infoPanelIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        CurrentQPage currentQPage = new CurrentQPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //throw new PendingException();
    }


    @And("I shuffle Artist")
    public void iShuffleArtist() {
        CurrentQPage currentQPage = new CurrentQPage(driver);
        currentQPage.ShuffleArtistBtn();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Then("I shuffle Album")
    public void iShuffleAlbum() {
        // Write code here that turns the phrase above into concrete actions
        CurrentQPage currentQPage = new CurrentQPage(driver);
        currentQPage.ShuffleAlbumBtn();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //throw new PendingException();
    }

    @And("I display Total Song Count and Duration")
    public void iDisplayTotalSongCountAndDuration() {
        // Write code here that turns the phrase above into concrete actions
        CurrentQPage currentQPage = new CurrentQPage(driver);
        currentQPage.getTotalCountMin();
        Assert.assertFalse(currentQPage.getTotalCountMin().isBlank());
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //throw new PendingException();
    }

    @And("I display Table Headers")
    public void iDisplayTableHeaders() {
        // Write code here that turns the phrase above into concrete actions
        CurrentQPage currentQPage = new CurrentQPage(driver);
        currentQPage.getCurrentTableHeader();
        Assert.assertFalse(currentQPage.getCurrentTableHeader().isBlank());
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //throw new PendingException();
    }

    @And("I shuffle All")
    public void iShuffleAll() {
        // Write code here that turns the phrase above into concrete actions
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        //CurrentQPage currentQPage = new CurrentQPage(driver);
        allSongsPage.ShuffleAllBtn();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //throw new PendingException();
    }

    @And("I Clear All")
    public void iClearAll() {
        // Write code here that turns the phrase above into concrete actions
        CurrentQPage currentQPage = new CurrentQPage(driver);
        currentQPage.ClearBtn();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //throw new PendingException();
    }

    @Then("Current Queue Clear Page is displayed")
    public void currentQueueClearPageIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        CurrentQPage currentQPage = new CurrentQPage(driver);
        currentQPage.getClearPageMsg();
        Assert.assertTrue(currentQPage.getClearPageMsg().contains("shuffling all songs"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //throw new PendingException();
    }

    @And("I enter Name {string}")
    public void iEnterName(String name) {
        // Write code here that turns the phrase above into concrete actions
        ProfilePage profilePage = new ProfilePage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='inputProfileName']"))).clear();
        profilePage.provideName(name);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //throw new PendingException();
    }

    @And("I enter new email {string}")
    public void iEnterNewEmail(String email) {
        ProfilePage profilePage = new ProfilePage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='inputProfileEmail']"))).clear();
        profilePage.provideEmail(email);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @And("I click theme")
    public void iClickTheme() {
        // Write code here that turns the phrase above into concrete actions
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.chooseVioletTheme();
        //throw new PendingException();
    }

    @Then("I check Now Playing")
    public void iCheckNowPlaying() {
        // Write code here that turns the phrase above into concrete actions
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickShowNow();
        //throw new PendingException();
    }

    @Then("I check Confirmation")
    public void iCheckConfirmation() {
        // Write code here that turns the phrase above into concrete actions
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickConfirm();
        //throw new PendingException();
    }

    @Then("I check show translucent")
    public void iCheckShowTranslucent() {
        // Write code here that turns the phrase above into concrete actions
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickShowTran();
        //throw new PendingException();
    }

    @Then("Recently Played Label is displayed")
    public void recentlyPlayedLabelIsdisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getRecentlyPlayedLbl().contains("Recently Played"));
        //throw new PendingException();
    }

    @Then("View All Button is displayed")
    public void viewAllButtonIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getViewAll().isDisplayed());
        //throw new PendingException();
    }

    @Then("Recently Added Songs is displayed")
    public void recentlyAddedSongsIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getRecentlyAddedLbl().contains("Recently Added"));
        //throw new PendingException();
    }

    @Then("Recently Added Album is displayed")
    public void recentlyAddedAlbumIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getRecentlyAddedLbl().contains("Recently Added"));
       //throw new PendingException();
    }

    @Then("Search field is displayed")
    public void searchFieldIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getSearchFld().isDisplayed());
        //throw new PendingException();
    }

    @And("Most Played Label is displayed")
    public void mostPlayedLabelIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getMostPlayedLbl().contains("Most Played"));
        //throw new PendingException();
    }

    @And("Top Artists is displayed")
    public void topArtistsIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getTopArtistsLbl().contains("Top Artists"));
        //throw new PendingException();
    }

    @And("Top Albums is displayed")
    public void topAlbumsIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getTopAlbumsLbl().contains("Top Albums"));
        //throw new PendingException();
    }

    @And("Playlist Button is displayed")
    public void playlistButtonIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getPlaylist().isDisplayed());
        //throw new PendingException();
    }

    @And("Favorites Label is displayed")
    public void favoritesLabelIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getFavorites().isDisplayed());
        //throw new PendingException();
    }

    @And("Playlist Recently Played Label is displayed")
    public void playlistRecentlyPlayedLabelIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getplaylistRecentlyplayedBtn().isDisplayed());
        //throw new PendingException();
    }

    @And("New Playlist Label is displayed")
    public void newPlaylistLabelIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getNewPlaylistBtn().isDisplayed());
        //throw new PendingException();
    }

    @And("Profile Image is displayed")
    public void profileImageIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getProfileBtn().isDisplayed());
        //throw new PendingException();
    }

    @And("About Image is displayed")
    public void aboutImageIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getAboutAvatar().isDisplayed());
        //throw new PendingException();
    }

    @And("I close About Page")
    public void iCloseAboutPage() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        homePage.clickAboutClose();
        //throw new PendingException();
    }

    @And("Logout Image is displayed")
    public void logoutImageIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getLogoutAvatar().isDisplayed());
        //throw new PendingException();
    }

    @And("I open About Page")
    public void iOpenAboutPage() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        homePage.clickAboutBtn();
        //throw new PendingException();
    }
}
