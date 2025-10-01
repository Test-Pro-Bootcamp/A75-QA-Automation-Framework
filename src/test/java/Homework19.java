import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist () throws InterruptedException {
        //expected string for deleted playlist message
        String expectedString = "Deleted playlist \"Wiles Playlist.\"";
       //preconditions (login)
        provideEmail("wiley.griffin@testpro.io");
        providePassword("KUgY8Y1p");
        submitBtn();
        Thread.sleep(2000);

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
