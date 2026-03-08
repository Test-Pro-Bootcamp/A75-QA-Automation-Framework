import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class HomePageTests extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        //Preconditions
       loginPage.login();

        //Steps
        homePage.clickNextBtn();
        homePage.clickPlay();

        //Verification
        Assert.assertTrue(homePage.pauseBtnShowing());


    }

}
