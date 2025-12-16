import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.LoginPage;
import pagefactory.ProfilePreferencesPage;

/**
 * @author wiles42
 */
public class ChangeEmailTest extends BaseTest {
    @Test
    public void missingAtSymbol() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferencesPage = new ProfilePreferencesPage(getDriver());

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("VA823kDO");
        loginPage.clickSubmit();

        profilePreferencesPage.clickProfilePage();
        profilePreferencesPage.inputCurrentPassword("VA823kDO");
        profilePreferencesPage.inputNewEmail("wiley.griffintestpro");
        Assert.assertEquals(profilePreferencesPage.getEmailValidation(), "Please include an '@' in the email address. 'wiley.griffintestpro' is missing an '@'.");

        profilePreferencesPage.inputNewEmail("wiley.griffin@testppzm000apo");
        Assert.assertTrue(profilePreferencesPage.successfulUpdate()); // this is a bug should have an error message instead of success message

        profilePreferencesPage.inputCurrentPassword("VA823kDO");
        profilePreferencesPage.inputNewEmail("wiley.griffin@testppzm000apo");
        Assert.assertTrue(profilePreferencesPage.successfulUpdate()); // this is a bug should have an error message instead of success message

        profilePreferencesPage.inputNewEmail("wiley.griffin@testpro.");
        Assert.assertEquals(profilePreferencesPage.getEmailValidation(), "'.' is used at a wrong position in 'testpro.'.");


    }
}
