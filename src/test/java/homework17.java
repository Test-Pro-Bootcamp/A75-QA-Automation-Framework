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

     viewAll();

     clickSong();

     addToBtn();

     addToPlaylist();

     successShow();


     //Expected Result
     Assert.assertEquals(successShow(), ExpectedString);









}

}
