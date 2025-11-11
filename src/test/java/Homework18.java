import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        String ExpectedString = "Added 1 song into \"Test Pro Playlist.\"";
        naviagionURL("https://qa.koel.app/");

        loginPage.provideEmail("felicia.clay@testpro.io");
        loginPage.providePassword("ACw0FWOe");
        loginPage.clickSubmit();

        searchSong("HoliznaCCO");
        clickViewALLBtn();
        selectFirstSong();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertEquals(getAddToPlaylistSuccessMsg(),ExpectedString);

        playnextSong();

        clickPause();
        Assert.assertFalse(isSongPlaying());

    }
    public boolean isSongPlaying() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='sound-bar-play']")));
        return soundBar.isDisplayed();
    }
}
