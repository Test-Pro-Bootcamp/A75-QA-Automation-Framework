import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.*;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

/**
 * @author wiles42
 */
public class SprintLoginTests extends BaseTest {

    @Test    // Login Verify Homepage
    public void HappyPathLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String homeURL = "https://qa.koel.app/#!/home";

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.isAt());
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void navigateToAllPages() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AlbumPage albumPage = new AlbumPage(getDriver());
        CurrentQuePage currentQuePage = new CurrentQuePage(getDriver());
        ArtistsPage artistsPage = new ArtistsPage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());
        FavoritesPage favoritesPage = new FavoritesPage(getDriver());
        RecentlyPlayedPage recentlyPlayedPage = new RecentlyPlayedPage(getDriver());
        MyPlaylistPage myPlaylistPage = new MyPlaylistPage(getDriver());
        String albumPageHeader = "Albums";
        String quePageHeader = "Current Queue";
        String artistPageHeader = "Artists";
        String allSongsHead = "All Songs";
        String favoritesHead = "Songs You Love";
        String recentlyPlayed = "Recently Played";
        String wileyPlaylist = "Wiley Playlist";


        // Pre Condition User Logs in successfully
        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        //User Verifies they've landed on the Home Page
        Assert.assertTrue(homePage.isAt());
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        // User Navigates to Albums Page
        albumPage.clickAlbumPage();
        // User Verifies the header on the Albums page
        assertEquals(albumPage.getAlbumHeaderText(), albumPageHeader);

        //User Navigates to Current Que page
        currentQuePage.clickQue();
        //User Verifies the header of the Current Que page
        assertEquals(currentQuePage.getQueHeaderText(), quePageHeader);


        // User Navigates to Artists Page
        artistsPage.clickArtistPage();
        // User Verifies the header on the Artist Page
        assertEquals(artistsPage.getArtistHeaderText(), artistPageHeader);
        // Navigate to All Songs Page
        allSongsPage.clickAllSongsPage();
        // Verify All Songs Header is present
        assertEquals(allSongsPage.getAllSongsHeaderText(), allSongsHead);

        // User Navigates to Favorites Page
        favoritesPage.clickFavorites();
        // Verify Header on Favorites Page
        assertEquals(favoritesPage.getFavoritesHeader(), favoritesHead);

        recentlyPlayedPage.recentlyPlayedClick();
        assertEquals(recentlyPlayedPage.recentlyPlayHeader(), recentlyPlayed);

        myPlaylistPage.clickPlaylist();
        assertEquals(myPlaylistPage.playlistHeader(), wileyPlaylist);


    }

    @Test
    public void userTakenBackToHomePage() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.isAt());
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        loginPage.logout();

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.isAt());
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void takenBackToAlbumPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        AlbumPage albumPage = new AlbumPage(getDriver());
        String albumPageHeader = "Albums";

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        albumPage.clickAlbumPage();
        // User Verifies the header on the Albums page
        assertEquals(albumPage.getAlbumHeaderText(), albumPageHeader);
        loginPage.logout();

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        assertEquals(albumPage.getAlbumHeaderText(), albumPageHeader);
    }

    @Test
    public void takenBackToAllSongPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());
        String allSongsHead = "All Songs";

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        // User Navigates to Albums Page
        allSongsPage.clickAllSongsPage();
        // User Verifies the header on the Albums page
        assertEquals(allSongsPage.getAllSongsHeaderText(), allSongsHead);

        loginPage.logout();

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        assertEquals(allSongsPage.getAllSongsHeaderText(), allSongsHead);
    }

    @Test
    public void takenBackToCurrentQuePage() {
        LoginPage loginPage = new LoginPage(getDriver());
        CurrentQuePage currentQuePage = new CurrentQuePage(getDriver());
        String quePageHeader = "Current Queue";

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        //User Navigates to Current Que page
        currentQuePage.clickQue();
        //User Verifies the header of the Current Que page
        assertEquals(currentQuePage.getQueHeaderText(), quePageHeader);

        loginPage.logout();

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        assertEquals(currentQuePage.getQueHeaderText(), quePageHeader);


    }

    @Test
    public void takenBackToArtistPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        ArtistsPage artistsPage = new ArtistsPage(getDriver());
        String artistPageHeader = "Artists";

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        // User Navigates to Artists Page
        artistsPage.clickArtistPage();
        // User Verifies the header on the Artist Page
        assertEquals(artistsPage.getArtistHeaderText(), artistPageHeader);

        loginPage.logout();

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        assertEquals(artistsPage.getArtistHeaderText(), artistPageHeader);
    }

    @Test
    public void takenBackToFavorites() {
        LoginPage loginPage = new LoginPage(getDriver());
        FavoritesPage favoritesPage = new FavoritesPage(getDriver());
        String favoritesHead = "Songs You Love";

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        favoritesPage.clickFavorites();
        assertEquals(favoritesPage.getFavoritesHeader(), favoritesHead);

        loginPage.logout();

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        assertEquals(favoritesPage.getFavoritesHeader(), favoritesHead);

    }

    @Test
    public void takenBackToRecentlyPlayedPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        RecentlyPlayedPage recentlyPlayedPage = new RecentlyPlayedPage(getDriver());
        String recentlyPlayed = "Recently Played";

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        recentlyPlayedPage.recentlyPlayedClick();
        assertEquals(recentlyPlayedPage.recentlyPlayHeader(), recentlyPlayed);

        loginPage.logout();

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        assertEquals(recentlyPlayedPage.recentlyPlayHeader(), recentlyPlayed);


    }

    @Test
    public void takenBackToMyPlaylistPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        MyPlaylistPage myPlaylistPage = new MyPlaylistPage(getDriver());
        String wileyPlaylist = "Wiley Playlist";

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        myPlaylistPage.clickPlaylist();
        assertEquals(myPlaylistPage.playlistHeader(), wileyPlaylist);

        loginPage.logout();

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        assertEquals(myPlaylistPage.playlistHeader(), wileyPlaylist);
    }

    @Test
    public void invalidEmailValidPassWord() {
        LoginPage loginPage = new LoginPage(getDriver());
        String loginURL = "https://qa.koel.app/";

        loginPage.provideEmail("wiley.griffintestpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        assertEquals(getDriver().getCurrentUrl(), loginURL);

    }

    @Test
    public void invalidEmailNoDomain() {
        LoginPage loginPage = new LoginPage(getDriver());
        String loginURL = "https://qa.koel.app/";

        loginPage.provideEmail("wiley.griffin@testpro.");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        assertEquals(getDriver().getCurrentUrl(), loginURL);

    }

    @Test
    public void invalidEmailNoDot() {
        LoginPage loginPage = new LoginPage(getDriver());
        String loginURL = "https://qa.koel.app/";

        loginPage.provideEmail("wiley.griffin@testproio");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();

        assertEquals(getDriver().getCurrentUrl(), loginURL);

    }

    @Test
    public void invalidPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        String loginURL = "https://qa.koel.app/";

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx3");
        loginPage.clickSubmit();

        Assert.assertTrue(loginPage.redError());


    }
    @Test
    public void emptyEmailPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        String loginURL = "https://qa.koel.app/";

        loginPage.provideEmail("");
        loginPage.providePassword("");
        loginPage.clickSubmit();

        assertEquals(getDriver().getCurrentUrl(), loginURL);

    }
}
