//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

//import java.time.Duration;

public class HomeWork17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String ExpectedString = "Added 1 song into \"HM17.\"";
        naviagionURL();
        //logs in
        provideEmail("daniel.vasquez@testpro.io");
        providePassword("Redgrave135!");
        clickSubmitBtn();
        //search for the song
        Thread.sleep(2000);
        searchSong("Dark Days");
        Thread.sleep(2000);
        clickViewALLBtn();
        Thread.sleep(2000);
        selectFirstSong();
        //click add to playlist
        Thread.sleep(2000);
        clickAddToBtn();
        Thread.sleep(2000);
        choosePlaylist();
        // check for toast
        Thread.sleep(5000);
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), ExpectedString);

    }
}