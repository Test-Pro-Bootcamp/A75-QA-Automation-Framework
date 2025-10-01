import org.testng.Assert;
import org.testng.annotations.Test;

public class homework17 extends BaseTest{
 @Test
public void addSongToPlaylist() throws InterruptedException {
String ExpectedString = "Added 1 song into \"Wiles Playlist.\"";
 //preconditions
    provideEmail("wiley.griffin@testpro.io");
    providePassword("KUgY8Y1p");
    submitBtn();
    Thread.sleep(2000);


    //Steps
     searchSong("song");
     Thread.sleep(2000);
     viewAll();
     Thread.sleep(2000);
     clickSong();
     Thread.sleep(2000);
     addToBtn();
     Thread.sleep(2000);
     addToPlaylist();
     Thread.sleep(2000);
     successShow();
     Thread.sleep(2000);

     //Expected Result
     Assert.assertEquals(successShow(), ExpectedString);









}

}
