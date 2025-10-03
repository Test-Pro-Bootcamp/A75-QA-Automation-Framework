import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException{
        String ExpectedString = "Deleted playlist \"Test Pro Playlist.\"";

        provideEmail("felicia.clay@testpro.io");
        providePassword("ACw0FWOe");
        clickSubmitBtn();
        Thread.sleep(2000);
        choosePlaylist();
        clickDeletePlaylistBtn();
        clickOkBtn();
        Assert.assertEquals(getDeletePlaylistSuccessMsg(),ExpectedString);

    };

}
