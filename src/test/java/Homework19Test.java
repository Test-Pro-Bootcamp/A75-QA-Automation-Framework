import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework19Test extends BaseTest {
    @Test
    public  void secondDeletePlaylist () throws InterruptedException {
        String expectedString = "Deleted playlist \"Wiles Playlist.\"";
        //Preconditions
        provideEmail("wiley.griffin@testpro.io");
        providePassword("KUgY8Y1p");
        submitBtn();
        Thread.sleep(2000); //

        //Steps
        //find and click playlist
        clickPlaylist();
        Thread.sleep(2000);
        //Click "x Playlist"
        deletethePlaylist();
        Thread.sleep(2000);
        //Verify "Deleted playlist Wiles Playlist"
        deletedPlaylistMessage();
        Thread.sleep(2000);
        Assert.assertEquals(deletedPlaylistMessage(), expectedString);
    }
}


