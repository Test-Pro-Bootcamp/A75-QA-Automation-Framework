import net.bytebuddy.build.Plugin;
import org.apache.hc.core5.reactor.Command;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.S1LoginPageCss;
import pagefactory.S1RegPage;

import java.sql.SQLOutput;

/**
 * @author wiles42
 */
public class SprintOneAccountCreation extends BaseTest{
    @Test (priority = 1)
    public void registerNewAccount(){
        S1LoginPageCss s1LoginPageCss = new S1LoginPageCss(getDriver());
        S1RegPage s1RegPage = new S1RegPage(getDriver());

        s1LoginPageCss.clickReg();
        s1RegPage.enterEmail("wiley.griffin+1@testpro.io");
        s1RegPage.clickSbMit();
        Assert.assertTrue(s1RegPage.successMessage()); // this is a bug. User should NOT be able to create an account with +1
    }
    @Test (priority = 2)
    public void loginWithNewAccount(){
        S1LoginPageCss s1LoginPageCss = new S1LoginPageCss(getDriver());
        S1RegPage s1RegPage = new S1RegPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        s1LoginPageCss.giveEmail("wiley.griffin+1@testpro.io");
        s1LoginPageCss.givePssWrd("Mj1i6F8F");
        s1LoginPageCss.clckSubmt();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(homePage.Avateristhere()); // expected behavior account created logins successfully

    }
    @Test (priority = 3)
    public void invalidEmail(){
        S1LoginPageCss s1LoginPageCss = new S1LoginPageCss(getDriver());
        S1RegPage s1RegPage = new S1RegPage(getDriver());


        s1LoginPageCss.clickReg();
        s1RegPage.enterEmail("Wiley.griffin!!testpro.io");
        s1RegPage.clickSbMit();
        String message = s1RegPage.validationErrMsg();
        System.out.println("Validation message" + message);
        Assert.assertEquals(message, "Please include an '@' in the email address. 'Wiley.griffin!!testpro.io' is missing an '@'."); // expected behavior
    }
    @Test (priority = 4)
    public void registerSameAccount(){
        S1LoginPageCss s1LoginPageCss = new S1LoginPageCss(getDriver());
        S1RegPage s1RegPage = new S1RegPage(getDriver());

        s1LoginPageCss.clickReg();
        s1RegPage.enterEmail("wiley.griffin+1@testpro.io");
        s1RegPage.clickSbMit();
        Assert.assertTrue(s1RegPage.successMessage()); // bug because the user flow does not differentiate between registration and new password
    }

}
