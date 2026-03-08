import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.FavoritesPage;
import pagefactory.HomePage;
import pagefactory.LoginPage;

/**
 * @author wiles42
 */
public class FavoritesTest extends BaseTest {
    @Test
    public void FavoriteTestFlow(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        FavoritesPage favoritesPage = new FavoritesPage(getDriver());

        String firstSong = "HoliznaCC0 - Way Of The Samurai";

        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("VA823kDO");
        loginPage.clickSubmit();

        favoritesPage.clickFavorites();
        Assert.assertTrue(favoritesPage.noFavoriteImage());

        homePage.clickHomeLink();
        homePage.likeFirstSong();


        favoritesPage.clickFavorites();
        Assert.assertEquals(favoritesPage.firstFavoriteInList(),firstSong);

        favoritesPage.clickFirstFavoriteBtn();
        Assert.assertTrue(favoritesPage.noFavoriteImage());

    }
}
