import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    private static final String PLAYLIST_NAME = "HW20_Playlist";

    @Parameters("baseUrl")
    @Test
    public void deletePlaylist_usesExplicitWaits(String baseUrl) {
        // Navigate & login
        navigateToUrl(baseUrl);
        login("daniel.vasquez@testpro.io", "Redgrave135!");

        // Ensure exists, open, delete (all helpers already use explicit waits)
        createPlaylistIfMissing(PLAYLIST_NAME);
        openPlaylist(PLAYLIST_NAME);
        deleteCurrentPlaylist(PLAYLIST_NAME);           // waits for toast OR invisibility

        // Optional: toast check (safe — returns "" when none)
        String toast = getNotificationText();
        if (!toast.isEmpty()) {
            Assert.assertTrue(
                    toast.startsWith("Deleted playlist") && toast.contains(PLAYLIST_NAME),
                    "Unexpected notification: " + toast
            );
        }

        // Result-based assertion (explicit wait already happened, this is a final check)
        Assert.assertFalse(playlistExists(PLAYLIST_NAME),
                "Playlist still present in sidebar after delete.");
    }
}