import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.LoginPage;
import pagefactory.MyPlaylistPage;

/**
 * @author wiles42
 */
public class NewPlaylistCreation extends BaseTest {
    @Test
    public void newPlaylistTests(){
        LoginPage loginPage = new LoginPage(getDriver());
        MyPlaylistPage myPlaylistPage = new MyPlaylistPage(getDriver());

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("GuitarL3ss0n1!");
        loginPage.clickSubmit();

        myPlaylistPage.clickPlaylistBtn();
        myPlaylistPage.clickNewPlaylist();
        myPlaylistPage.inputNewPlaylistName("Wiley's New Playlist");
        Assert.assertTrue(myPlaylistPage.newPlaylistSuccess());

    }
    @Test
    public void samePlaylistName(){
        LoginPage loginPage = new LoginPage(getDriver());
        MyPlaylistPage myPlaylistPage = new MyPlaylistPage(getDriver());

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("guitarl3ss0n1!");
        loginPage.clickSubmit();
        myPlaylistPage.clickPlaylistBtn();
        myPlaylistPage.clickNewPlaylist();
        myPlaylistPage.inputNewPlaylistName("Wiley's New Playlist");
        Assert.assertTrue(myPlaylistPage.newPlaylistSuccess()); // This is a bug, this test should fail
    }
    @Test
    public void lessThanThreeCharacters(){
        LoginPage loginPage = new LoginPage(getDriver());
        MyPlaylistPage myPlaylistPage = new MyPlaylistPage(getDriver());

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("guitarl3ss0n1!");
        loginPage.clickSubmit();
        myPlaylistPage.clickPlaylistBtn();
        myPlaylistPage.clickNewPlaylist();
        myPlaylistPage.inputNewPlaylistName("W");
        Assert.assertTrue(myPlaylistPage.newPlaylistSuccess()); // This is a bug, this test should fail


    }
    @Test
    public void moreThanTenCharacters(){
        LoginPage loginPage = new LoginPage(getDriver());
        MyPlaylistPage myPlaylistPage = new MyPlaylistPage(getDriver());

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("guitarl3ss0n1!");
        loginPage.clickSubmit();
        myPlaylistPage.clickPlaylistBtn();
        myPlaylistPage.clickNewPlaylist();
        myPlaylistPage.inputNewPlaylistName("Wwwwwwwwwwwwwwwwwwwwww");
        Assert.assertTrue(myPlaylistPage.newPlaylistSuccess()); // This is a bug, this test should fail


    }




}
