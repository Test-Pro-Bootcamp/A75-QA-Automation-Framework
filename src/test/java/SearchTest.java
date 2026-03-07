import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.LoginPage;
import pagefactory.SearchPage;

/**
 * @author wiles42
 */
public class SearchTest extends BaseTest{
    @Test
    public void Search (){
        LoginPage loginPage = new LoginPage(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());

        String albumResult = "None found.";
        String artistResult = "None found.";
        String emptySongResult = "None found.";
        String newSongFound = "Epic Song\nBoxCat Games";



        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("VA823kDO");
        loginPage.clickSubmit();

        searchPage.clickSearch();
        searchPage.inputSearch("Song");
        Assert.assertEquals(searchPage.songFound(), newSongFound);
        Assert.assertEquals(searchPage.albumFound(),albumResult);
        Assert.assertEquals(searchPage.artistFound(), artistResult);

        searchPage.clickSearch();
        searchPage.inputSearch("dilla");
        Assert.assertEquals(searchPage.noSongFound(),emptySongResult);
        Assert.assertEquals(searchPage.albumFound(),albumResult);
        Assert.assertEquals(searchPage.artistFound(), artistResult);

        searchPage.clickSearch();
        searchPage.keyClearSearch();
        Assert.assertTrue(searchPage.searchEmpty());
    }

}
