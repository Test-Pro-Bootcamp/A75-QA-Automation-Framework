import org.testng.Assert;
import org.testng.annotations.Test;
import pom.AllSongsPage;
import pom.FavoritesPage;
import pom.LoginPage;

/**
 * @author wiles42
 */
public class S2Favorites extends BaseTest {
    @Test (priority = 1)
    public void noFavorites(){
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login();
        favoritesPage.goToFavorites();
        Assert.assertTrue(favoritesPage.noFavoritesImg().isDisplayed());

    }
    @Test (priority = 2)
    public void heartThreeFavorites(){
        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        FavoritesPage favoritesPage = new FavoritesPage(driver);

        loginPage.login();
        allSongsPage.goToAllSongsPage();
        allSongsPage.firstSongHear();
        allSongsPage.secondSongHeart();
        allSongsPage.thirdSongHeart();
        favoritesPage.goToFavorites();
        Assert.assertTrue(favoritesPage.firstSongThere());
        Assert.assertTrue(favoritesPage.secondSongThere());
        Assert.assertTrue(favoritesPage.thirdSongThere());
    }
    @Test(priority = 3)
    public void unheartSongs() {
        LoginPage loginPage =new LoginPage(driver);
        FavoritesPage favoritesPage =new FavoritesPage(driver);

        loginPage.login();
        favoritesPage.goToFavorites();
        favoritesPage.unFavoriteAllSongs();
        Assert.assertTrue(favoritesPage.noFavoritesImg().isDisplayed());
    }
}
