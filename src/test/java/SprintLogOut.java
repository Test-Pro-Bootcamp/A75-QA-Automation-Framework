import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.BasePage;
import pagefactory.HomePage;
import pagefactory.LoginPage;

/**
 * @author wiles42
 */
public class SprintLogOut extends BaseTest {
    @Test
    public void logOutBtnPresent(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();
        Assert.assertTrue(loginPage.logOutBtnVisible());
    }
    @Test
    public void logInAndOut(){
        //Precondition login
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();
        // Verify Login button is present
        Assert.assertTrue(loginPage.logOutBtnVisible());
        // Log Out
        loginPage.logout();
       // Verify user is logged out
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

}
