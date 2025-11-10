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
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();
        Assert.assertTrue(loginPage.logOutBtnVisible());
        loginPage.logout();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

}
