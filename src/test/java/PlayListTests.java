import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;
import pom.PlayListPage;
import pom.SearchResultsPage;

public class PlayListTests extends BaseTest {
    @Test
    public void addSongToPlaylist() {
        PlayListPage playListPage = new PlayListPage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        String ExpectedString = "Added 1 song into \"Wiles Playlist.\"";
        //preconditions

        loginPage.login();


        //Steps
        homePage.searchNewSong("song");
        searchResultsPage.viewSongResults();
        searchResultsPage.clickOnSong();
        searchResultsPage.addSongBtn();
        searchResultsPage.addToNewPlayList();
        playListPage.newSuccessShow();


        //Expected Result
        Assert.assertEquals(playListPage.newSuccessShow(), ExpectedString);

    }
    @Test
    public  void secondDeletePlaylist ()  {
        String expectedString = "Deleted playlist \"fdas.\"";
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);

        //Preconditions
        loginPage.login();


        //Steps
        playListPage.clickPlaylist();
        playListPage.deleteThePlaylist();
        //playListPage.okButton(); .. only if there is a song in playlist!

        //Verification
        playListPage.deletedPlaylistMessage();

        Assert.assertEquals(playListPage.deletedPlaylistMessage(), expectedString);
    }
    @Test
    public void newPlaylistName(){
        //Preconditions
        PlayListPage playListPage = new PlayListPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String updatedMsg = "Updated playlist \"Wiley Playlist.\"";

        loginPage.login();


        //Steps
        playListPage.doubleClick();
        playListPage.newPlaylistName("Wiley Playlist");
        Assert.assertEquals(playListPage.newSuccessShow(), updatedMsg);

    }

}
