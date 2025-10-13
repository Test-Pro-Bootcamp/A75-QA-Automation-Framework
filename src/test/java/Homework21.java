import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.BasePage;
import pagefactory.HomePage;
import pagefactory.LoginPage;

/**
 * @author wiles42
 */
public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist() {
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

       //Preconditions
      String updatedMsg = "Updated playlist \"Wiley Playlist.\"";
        loginPage.provideEmail("wiley.griffin@testpro.io")
                .providePassword("KUgY8Y1p")
                .clickSubmit();
       
       //Steps
        homePage.dblClickPlaylist();
        homePage.inputName("Wiley Playlist");

        //Verification
        Assert.assertEquals(homePage.successMessage(), updatedMsg);

    }

}
