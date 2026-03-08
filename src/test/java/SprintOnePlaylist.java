import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.S1LoginPageCss;
import pagefactory.S1NewPlaylist;

/**
 * @author wiles42
 */
public class SprintOnePlaylist extends BaseTest {
    @Test(priority = 1)
    public void createValidPlaylist() {
        S1LoginPageCss s1LoginPageCss = new S1LoginPageCss(getDriver());
        S1NewPlaylist s1NewPlaylist = new S1NewPlaylist(getDriver());


        s1LoginPageCss.giveEmail("wiley.griffin@testpro.io");
        s1LoginPageCss.givePssWrd("GuitarL3ss0n1!");
        s1LoginPageCss.clckSubmt();
        s1NewPlaylist.clickPlayListBtn();
        s1NewPlaylist.clickNewPlayList();
        s1NewPlaylist.enterPlayListName("Wiley's List");
        Assert.assertTrue(s1NewPlaylist.successfulMsg()); //expected behavior

    }
    @Test(priority = 2)
    public void createOneCharacterList (){
        S1LoginPageCss s1LoginPageCss = new S1LoginPageCss(getDriver());
        S1NewPlaylist s1NewPlaylist = new S1NewPlaylist(getDriver());
        s1LoginPageCss.giveEmail("wiley.griffin@testpro.io");
        s1LoginPageCss.givePssWrd("GuitarL3ss0n1!");
        s1LoginPageCss.clckSubmt();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-testid='sidebar-create-playlist-btn']")
        ));
        s1NewPlaylist.clickPlayListBtn();
        s1NewPlaylist.clickNewPlayList();
        s1NewPlaylist.enterPlayListName("W");
        Assert.assertTrue(s1NewPlaylist.successfulMsg()); //bug should not receive success message

    }
    @Test(priority = 3)
    public void elevenCharacterPlayList(){
        S1LoginPageCss s1LoginPageCss = new S1LoginPageCss(getDriver());
        S1NewPlaylist s1NewPlaylist = new S1NewPlaylist(getDriver());
        s1LoginPageCss.giveEmail("wiley.griffin@testpro.io");
        s1LoginPageCss.givePssWrd("GuitarL3ss0n1!");
        s1LoginPageCss.clckSubmt();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-testid='sidebar-create-playlist-btn']")
        ));
        s1NewPlaylist.clickPlayListBtn();
        s1NewPlaylist.clickNewPlayList();
        s1NewPlaylist.enterPlayListName("Wwwwwwwwwww");
        Assert.assertTrue(s1NewPlaylist.successfulMsg()); //bug should not receive success message

    }
    @Test(priority = 4)
    public void duplicatePlayList() {
        S1LoginPageCss s1LoginPageCss = new S1LoginPageCss(getDriver());
        S1NewPlaylist s1NewPlaylist = new S1NewPlaylist(getDriver());


        s1LoginPageCss.giveEmail("wiley.griffin@testpro.io");
        s1LoginPageCss.givePssWrd("GuitarL3ss0n1!");
        s1LoginPageCss.clckSubmt();
        s1NewPlaylist.clickPlayListBtn();
        s1NewPlaylist.clickNewPlayList();
        s1NewPlaylist.enterPlayListName("Wiley's List");
        Assert.assertTrue(s1NewPlaylist.successfulMsg()); //bug no duplicates should not receive success message

    }

}
