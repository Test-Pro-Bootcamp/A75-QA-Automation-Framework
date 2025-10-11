import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.PlayListPage;

/**
 * @author wiles42
 */
public class Homework22 extends BaseTest {
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
