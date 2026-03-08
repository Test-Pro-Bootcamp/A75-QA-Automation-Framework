import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.LoginPage;
import pagefactory.S1LoginPageCss;
import pagefactory.S1ProfilePrefPageCss;

/**
 * @author wiles42
 */
public class sprintOneUpDtPassCssTests extends BaseTest {
    @Test(priority = 1)
    public void allLowerCase() {
        S1LoginPageCss s1LoginPageCss = new S1LoginPageCss(getDriver());
        S1ProfilePrefPageCss s1ProfilePrefPageCss = new S1ProfilePrefPageCss(getDriver());


        s1LoginPageCss.giveEmail("wiley.griffin@testpro.io");
        s1LoginPageCss.givePssWrd("GuitarL3ss0n1!");
        s1LoginPageCss.clckSubmt();
        s1ProfilePrefPageCss.clkProfPge();
        s1ProfilePrefPageCss.currentPassword("GuitarL3ss0n1!");
        s1ProfilePrefPageCss.newPassword("guitarL322s0n1!");
        s1ProfilePrefPageCss.clkSave();
        Assert.assertTrue(s1ProfilePrefPageCss.errMsg()); // bug this is supposed pass no upper case letter failed test


    }

    @Test(priority = 2)
    public void threeLetters() {
        S1LoginPageCss s1LoginPageCss = new S1LoginPageCss(getDriver());
        S1ProfilePrefPageCss s1ProfilePrefPageCss = new S1ProfilePrefPageCss(getDriver());


        s1LoginPageCss.giveEmail("wiley.griffin@testpro.io");
        s1LoginPageCss.givePssWrd("guitarl322s0n1!");
        s1LoginPageCss.clckSubmt();
        s1ProfilePrefPageCss.clkProfPge();
        s1ProfilePrefPageCss.currentPassword("guitarl322s0n1!");
        s1ProfilePrefPageCss.newPassword("aaa");
        s1ProfilePrefPageCss.clkSave();
        Assert.assertTrue(s1ProfilePrefPageCss.errMsg()); //expected behavior! pass


    }
    @Test(priority = 3)
    public void twentyNumAndChar() {
        S1LoginPageCss s1LoginPageCss = new S1LoginPageCss(getDriver());
        S1ProfilePrefPageCss s1ProfilePrefPageCss = new S1ProfilePrefPageCss(getDriver());

        s1LoginPageCss.giveEmail("wiley.griffin@testpro.io");
        s1LoginPageCss.givePssWrd("guitarl322s0n1!");
        s1LoginPageCss.clckSubmt();
        s1ProfilePrefPageCss.clkProfPge();
        s1ProfilePrefPageCss.currentPassword("guitarl322s0n1!");
        s1ProfilePrefPageCss.newPassword("aaa@aaa@aaa@aaa@aaa@");
        s1ProfilePrefPageCss.clkSave();
        Assert.assertTrue(s1ProfilePrefPageCss.errMsg()); //pass throws error msg

    }
    @Test(priority = 4)
    public void twentyPlusValid() {
        S1LoginPageCss s1LoginPageCss = new S1LoginPageCss(getDriver());
        S1ProfilePrefPageCss s1ProfilePrefPageCss = new S1ProfilePrefPageCss(getDriver());

        s1LoginPageCss.giveEmail("wiley.griffin@testpro.io");
        s1LoginPageCss.givePssWrd("guitarl322s0n1!");
        s1LoginPageCss.clckSubmt();
        s1ProfilePrefPageCss.clkProfPge();
        s1ProfilePrefPageCss.currentPassword("guitarl322s0n1!");
        s1ProfilePrefPageCss.newPassword("Guitar1!Guitar1!Guitar1!Guitar1!");
        s1ProfilePrefPageCss.clkSave();
        Assert.assertTrue(s1ProfilePrefPageCss.errMsg()); //bug test fails

    }
    @Test(priority = 5)
    public void upperLowSymbol(){
        S1LoginPageCss s1LoginPageCss = new S1LoginPageCss(getDriver());
        S1ProfilePrefPageCss s1ProfilePrefPageCss = new S1ProfilePrefPageCss(getDriver());

        s1LoginPageCss.giveEmail("wiley.griffin@testpro.io");
        s1LoginPageCss.givePssWrd("Guitar1!Guitar1!Guitar1!Guitar1!");
        s1LoginPageCss.clckSubmt();
        s1ProfilePrefPageCss.clkProfPge();
        s1ProfilePrefPageCss.currentPassword("Guitar1!Guitar1!Guitar1!Guitar1!");
        s1ProfilePrefPageCss.newPassword("Abb@bbb#rr");
        s1ProfilePrefPageCss.clkSave();
        Assert.assertTrue(s1ProfilePrefPageCss.errMsg()); // pass

    }
    @Test(priority = 6)
    public void upLowNum(){
        S1LoginPageCss s1LoginPageCss = new S1LoginPageCss(getDriver());
        S1ProfilePrefPageCss s1ProfilePrefPageCss = new S1ProfilePrefPageCss(getDriver());

        s1LoginPageCss.giveEmail("wiley.griffin@testpro.io");
        s1LoginPageCss.givePssWrd("Guitar1!Guitar1!Guitar1!Guitar1!");
        s1LoginPageCss.clckSubmt();
        s1ProfilePrefPageCss.clkProfPge();
        s1ProfilePrefPageCss.currentPassword("Guitar1!Guitar1!Guitar1!Guitar1!");
        s1ProfilePrefPageCss.newPassword("Ab1bbb23b2");
        s1ProfilePrefPageCss.clkSave();
        Assert.assertTrue(s1ProfilePrefPageCss.errMsg()); // pass error msg thrown

    }
   @Test(priority = 7)
    public void oldPassWrdFail (){
       S1LoginPageCss s1LoginPageCss = new S1LoginPageCss(getDriver());

       s1LoginPageCss.giveEmail("wiley.griffin@testpro.io");
       s1LoginPageCss.givePssWrd("GuitarL3ss0n1!");
       s1LoginPageCss.clckSubmt();
       Assert.assertTrue(s1LoginPageCss.redErr()); // pass old password does not work



   }
}
