import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist() throws InterruptedException{
        String ExpectedString = "Updated playlist \"Test Pro Playlist2.\"";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("felicia.clay@testpro.io");
        loginPage.providePassword("ACw0FWOe");
        loginPage.clickSubmit();
        rightclickPlaylist();
        clickEditPlaylist();
        enterList();

        Assert.assertEquals(getRenamePlaylistSuccessMsg(),ExpectedString);

    };
}
