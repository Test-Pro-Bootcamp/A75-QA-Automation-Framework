import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.AllSongsPage;
import pagefactory.CurrentQuePage;
import pagefactory.InfoPanelPage;
import pagefactory.LoginPage;

import java.util.List;

/**
 * @author wiles42
 */
public class SprintInfoPanelTests extends BaseTest {
    @Test
    public void artistShuffle(){


        LoginPage loginPage = new LoginPage(getDriver());
        InfoPanelPage infoPanelPage = new InfoPanelPage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());
        String artistName = "Unknown Artist";
        String albumName = "Unknown Album";
        //Pre Conditions Log In
        loginPage.provideEmail("wiley.griffin@testpro.io");
        loginPage.providePassword("oWRtHlx0");
        loginPage.clickSubmit();
        // Play A song
        allSongsPage.clickAllSongsPage();
        allSongsPage.playFirstSong();
        // Verify its playing
        Assert.assertTrue(allSongsPage.pauseBtnVisible());
       //Open info panel
        infoPanelPage.clickInfoPanel();
        //Verify info Panel opens
        Assert.assertTrue(infoPanelPage.infoPanelDisplayed());
       // Click Lyrics tab
        infoPanelPage.clickLyricsTab();
        // Verify Lyrics are present
        Assert.assertFalse(infoPanelPage.getLyrics().isEmpty());
        // Click Artist tab
        infoPanelPage.clickOnArtistTab();
       // Verify Artist Name is present
        Assert.assertEquals(infoPanelPage.clickOnArtistTab(), artistName);
        // Click Album tab
        infoPanelPage.getAlbumName();
        // Verify Album Name is present
        Assert.assertEquals(infoPanelPage.getAlbumName(),albumName);
        // Locate Album Cover
        infoPanelPage.albumCoverDisplayed();
        // Verify Album Cover is displayed
        Assert.assertTrue(infoPanelPage.albumCoverDisplayed());
        // Get the first song's name in the playlist
        infoPanelPage.getFirstSong();
        // Click Shuffle Album
        infoPanelPage.clickAlbumShuffle();
        // Get The new song's nane
        infoPanelPage.getSecondSong();
        String firstSong = infoPanelPage.getFirstSong();
        String secondSong = infoPanelPage.getSecondSong();
        // Verify the first song is not the same as the second song
        Assert.assertNotEquals(firstSong,secondSong);
        // Click on Artist tab
        infoPanelPage.clickOnArtistTab();
        // Get the first song's name
        infoPanelPage.getFirstSong();
        // Click Shuffle in the Album tab
        infoPanelPage.clickArtistShuffle();
        // Get Second song name
        infoPanelPage.getArtistSecondSong();
        String firstSongArtist = infoPanelPage.getFirstSong();
        String secondSongArtist = infoPanelPage.getArtistSecondSong();
        // Verify First song and Second song are the same
        Assert.assertEquals(firstSongArtist,secondSongArtist);
        // Click the info panel button
        infoPanelPage.clickInfoPanel();
        // Verify info panel is now closed
        Assert.assertTrue(infoPanelPage.closeInfoPanelIfOpen());















    }
}
