import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist () throws InterruptedException {
        //expected string for deleted playlist message
        String expectedString = "Deleted playlist \"Wiles Playlist.\"";
       //preconditions (login)
       // provideEmail("wiley.griffin@testpro.io");
        //providePassword("KUgY8Y1p");
        // submitBtn();


        //Steps
        //find and click playlist
        clickPlaylist();

        //Click "x Playlist"
        deletethePlaylist();

        //Verify "Deleted playlist Wiles Playlist"
        deletedPlaylistMessage();

        Assert.assertEquals(deletedPlaylistMessage(), expectedString);

    }

}
