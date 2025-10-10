import org.testng.Assert;
import org.testng.annotations.Test;
import pom.PlayListPage;

/**
 * @author wiles42
 */
public class Homework22 extends BaseTest {
    @Test
            public void newPlaylistName(){
        //Preconditions
        PlayListPage playListPage = new PlayListPage(driver);
        String updatedMsg = "Updated playlist \"Wiley Playlist.\"";
        provideEmail("wiley.griffin@testpro.io");
        providePassword("KUgY8Y1p");
        submitBtn();

       //Steps
        playListPage.doubleClick();
        playListPage.newPlaylistName("Wiley Playlist");
        Assert.assertEquals(successShow(), updatedMsg);

    }

}
