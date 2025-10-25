import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;
import pom.ProfilePage;

public class ProfileTests extends BaseTest{

    public void updateProfileName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.provideEmail("felicia.clay@testpro.io");
        providePassword("ACw0FWOe");
        loginPage.clickSubmit();

        Thread.sleep(2000);
        clickAvatarIcon();
        provideCurrentPassword("ACw0FWOe");

        var randomName = randomName();
        changeName(randomName);

        clickSaveBtn();

        Thread.sleep(2000);
        WebElement actualProfileName = getDriver().findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);
    }

    @Test
    public void changeCurrentTheme() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        loginPage.provideEmail("felicia.clay@testpro.io");
        loginPage.providePassword("ACw0FWOe");
        loginPage.clickSubmit();

        clickAvatarIcon();

        profilePage.chooseVioletTheme();

        Assert.assertTrue(profilePage.isVioletThemeSelected());
    }
}
