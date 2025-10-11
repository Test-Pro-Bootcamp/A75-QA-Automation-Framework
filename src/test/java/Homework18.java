import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() {
        //go to url and login
        navigateToUrl();
        login("daniel.vasquez@testpro.io", "Redgrave135!");

        //  select a track first
         clickAllSongsBtn();
         selectFirstSong();
         clickPlayNext();
         clickPlay();

        Assert.assertTrue(waitUntilPlaying(), "Expected Pause button to be visible (song should be playing).");
    }
}