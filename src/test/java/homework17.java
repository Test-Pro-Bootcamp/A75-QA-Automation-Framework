import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;
import pom.PlayListPage;
import pom.SearchResultsPage;

public class homework17 extends BaseTest{
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

}
