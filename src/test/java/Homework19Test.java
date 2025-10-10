import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework19Test extends BaseTest {
    @Test
    public  void secondDeletePlaylist () throws InterruptedException {
        String expectedString = "Deleted playlist \"Wiles Playlist.\"";
        //Preconditions
       // provideEmail("wiley.griffin@testpro.io");
       // providePassword("KUgY8Y1p");
       // submitBtn();


        //Steps
        //find and click playlist
        clickPlaylist();

        //Click "x Playlist"
        deletethePlaylist();

        //Verify "Deleted playlist Wiles Playlist"
        deletedPlaylistMessage();

        //okButton();

        Assert.assertEquals(deletedPlaylistMessage(), expectedString);
    }
}


