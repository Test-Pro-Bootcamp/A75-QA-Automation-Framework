import org.testng.Assert;
import org.testng.annotations.Test;

public class homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
                //Preconditions
        provideEmail("wiley.griffin@testpro.io");
        providePassword("KUgY8Y1p");
        submitBtn();
        Thread.sleep(2000);

        //Steps

        //Click Play next song
        nextBtn();
        //Click Play button
        playBtn();
        //Verify song is playing
        pauseBtn();
        Assert.assertTrue(pauseBtn());


    }

}
