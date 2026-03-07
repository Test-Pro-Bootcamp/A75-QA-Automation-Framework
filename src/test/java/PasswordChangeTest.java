import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.ProfilePreferencesPage;

/**
 * @author wiles42
 */
public class PasswordChangeTest extends BaseTest{
    @Test
    public void changePassWordTest(){
        ProfilePreferencesPage profilePreferencesPage = new ProfilePreferencesPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //login
        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("guitarl3sson1!");
        loginPage.clickSubmit();


        //navigate to profile page
        profilePreferencesPage.clickProfilePage();
        //change password
        profilePreferencesPage.inputCurrentPassword("guitarl3sson1!");
        profilePreferencesPage.inputNewPassword("guitarl3ss0n1!");
        profilePreferencesPage.clickSaveBtn();
       //logout
        profilePreferencesPage.clickLogOut();

        //login with invalid password
        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("guitarl3sson1!");
        loginPage.clickSubmit();

       //verify old password does not work
        Assert.assertTrue(loginPage.formError());


        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("guitarl3ss0n1!");
        loginPage.clickSubmit();

        //verify user is now at the homepage
        Assert.assertTrue(profilePreferencesPage.atProfilePage());





    }
}
