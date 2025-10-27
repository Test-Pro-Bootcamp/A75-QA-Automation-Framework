package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework21 extends BaseTest {

    @Test
    public void createRenameDeletePlaylist() {
        HomePage home = new LoginPage(driver)
                .loginAs("daniel.vasquez@testpro.io", "Redgrave135!");

        Assert.assertTrue(home.isLoaded(), "Home should be loaded");

        String base = "HW22_Playlist";
        String ts = String.valueOf(System.currentTimeMillis() / 1000);
        String name = base + "_" + ts;
        String renamed = name + "_Renamed";

        home.createPlaylistIfMissing(name);
        Assert.assertTrue(home.playlistExists(name), "Playlist should exist after create");

        home.renamePlaylist(name, renamed);
        Assert.assertTrue(home.playlistExists(renamed), "Playlist should be renamed");

        home.deleteCurrentPlaylist(renamed);
        Assert.assertFalse(home.playlistExists(renamed), "Playlist should be deleted");
    }
}
