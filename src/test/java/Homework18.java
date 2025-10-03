import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException{
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
        choosePlaylist();
        Thread.sleep(5000);
        Assert.assertEquals(getAddToPlaylistSuccessMsg(),ExpectedString);
        Thread.sleep(2000);
        playnextSong();
        Thread.sleep(5000);
        clickPause();
        Assert.assertFalse(isSongPlaying());

    }
    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }
}
