import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    private static final String PLAYLIST_NAME = "HW19_Playlist";

    @Parameters("baseUrl")
    @Test
    public void deletePlaylist(String baseUrl) {
        // Navigate with @Parameters and login
        navigateToUrl(baseUrl);
        login("daniel.vasquez@testpro.io", "Redgrave135!");

        // Ensure the playlist exists then open it
        createPlaylistIfMissing(PLAYLIST_NAME);
        openPlaylist(PLAYLIST_NAME);
        deleteCurrentPlaylist(PLAYLIST_NAME);

        String toast = getNotificationText();
        if (!toast.isEmpty()) {
            Assert.assertTrue(
                    toast.startsWith("Deleted playlist") && toast.contains(PLAYLIST_NAME),
                    "Unexpected notification: " + toast);
        }
    }
}
