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

        searchSong("HoliznaCCO");
        clickViewALLBtn();
        selectFirstSong();
        clickAddToBtn();
        choosePlaylist();

        Assert.assertEquals(getAddToPlaylistSuccessMsg(),ExpectedString);


    }
}
