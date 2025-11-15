import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException{
        String ExpectedString = "Deleted playlist \"Test Pro Play.\"";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("felicia.clay@testpro.io");
        loginPage.providePassword("ACw0FWOe");
        loginPage.clickSubmit();
        openPlaylist();
        clickDelPlaylistBtn();
        //clickDeletePlaylistBtn();
        //clickOkBtn();
        Assert.assertEquals(getDeletePlaylistSuccessMsg(),ExpectedString);

    };

}
