//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

//import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException{
       // String ExpectedString = "Added 1 song into \"Test Pro Playlist.\"";
        String ExpectedString = "Added 1 song into \"Test Pro Playlist.\"";
        naviagionURL("https://qa.koel.app/");
        provideEmail("felicia.clay@testpro.io");
        providePassword("ACw0FWOe");
        clickSubmitBtn();
        Thread.sleep(2000);
        searchSong("HoliznaCCO");
        Thread.sleep(2000);
        clickViewALLBtn();
        Thread.sleep(2000);
        selectFirstSong();
        Thread.sleep(2000);
        clickAddToBtn();
        Thread.sleep(2000);
       // createPlaylist("17SongList");
       // clickSaveBtn();
        choosePlaylist();
        Thread.sleep(5000);
        Assert.assertEquals(getAddToPlaylistSuccessMsg(),ExpectedString);



    }
}
