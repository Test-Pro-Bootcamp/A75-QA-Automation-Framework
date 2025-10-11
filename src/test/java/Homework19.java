import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.PlayListPage;


public class Homework19 extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(Homework19.class);

    @Test
    public  void secondDeletePlaylist ()  {
        String expectedString = "Deleted playlist \"Wiles Playlist.\"";
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
}


