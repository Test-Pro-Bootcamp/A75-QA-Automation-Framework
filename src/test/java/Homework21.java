import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework21 extends BaseTest {

    @Parameters("baseUrl")
    @Test
    public void renamePlaylist(String baseUrl) throws InterruptedException {
        // Login
        navigateToUrl(baseUrl);
        login("daniel.vasquez@testpro.io", "Redgrave135!");


        final String OLD = "HW21_Playlist";
        final String NEW = "HW21_Playlist_Erm";

        //  Ensure it exists
        createPlaylistIfMissing(OLD);

        //Rename via Actions + waits
        renamePlaylist(OLD, NEW);

        // Assert it really changed
        Assert.assertFalse(playlistExists(OLD), "Erm old playlist still present.");
        Assert.assertTrue(playlistExists(NEW), "Erm renamed playlist not found.");

        Thread.sleep(1_000); // wait 1 second before deleting this just cuz it happens to fast for me and I want to see it

        if (playlistExists(NEW)) {
            openPlaylist(NEW);
            deleteCurrentPlaylist(NEW);

            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.numberOfElementsToBe(By.xpath("//a[normalize-space(text())='" + NEW + "']"), 0));
        }
    }

}
