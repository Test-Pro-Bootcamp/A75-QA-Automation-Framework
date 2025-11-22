package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CurrentQPage extends BasePage{
    public CurrentQPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //By CurrentQMsg = By.xpath("//*[id='queueWrapper']/header/div[2]/h1/text()");
    By CurrentQMsg = By.xpath("//*[@id='queueWrapper']/header/div[2]/h1");
    public String getCurrentQMsg() {
        return findElement(CurrentQMsg).getText();
    }

    By firstSong = By.xpath("//*[@id='queueWrapper']/div/div/div[1]/table/tr[1]");

    public CurrentQPage choose1stSong() {
        doubleClick(firstSong);
        return this;
    }

    By AlbumName = By.xpath("//*[@id='extraPanelAlbum']/article/h1/span");
    public String getAlbumName() {
        return findElement(AlbumName).getText();
    }

    By AlbumTab = By.xpath("//*[@id='extraTabAlbum']");
    public CurrentQPage albumTab() {
        click(AlbumTab);
        return this;
    }

    By LyricsTab = By.xpath("//*[@id='extraTabLyrics']");
    public CurrentQPage lyricsTab () {
        click(LyricsTab);
        return this;
    }

   By LyricsName = By.xpath("//*[@id='lyrics']/div/p/span");
    public String getLyricsName() {
        return findElement(LyricsName).getText();
    }

    By ArtistsTab = By.xpath("//*[@id='extraTabArtist']");
    public CurrentQPage ArtistsTab () {
        click(ArtistsTab);
        return this;
    }
    By ArtistName = By.xpath("//*[@id='extraPanelArtist']/article/h1/span");
    public String getArtistName() {
        return findElement(ArtistName).getText();
    }

    By InfoBtn = By.xpath("//*[@id='mainFooter']/div[2]/div[2]/div/button[2]");
    public CurrentQPage InfoBtn () {
        click(InfoBtn);
        return this;
    }

    By ShuffleArtistBtn = By.xpath("//*[@id='extraPanelArtist']/article/h1/button");
    public CurrentQPage ShuffleArtistBtn () {
        click(ShuffleArtistBtn);
        return this;
    }

    By ShuffleAlbumBtn = By.xpath("//*[@id='extraPanelAlbum']/article/h1/button");
    public CurrentQPage ShuffleAlbumBtn () {
        click(ShuffleAlbumBtn);
        return this;
    }
    By getCurrentTableHeader = By.xpath("//*[@id='queueWrapper']/div/table/thead/tr");
    public String getCurrentTableHeader () {
        return findElement(getCurrentTableHeader).getText();
    }

    By getTotalCountMin = By.xpath("//*[@id='queueWrapper']/header/div[2]/span/span");
    public String getTotalCountMin () {
        return findElement(getTotalCountMin).getText();
    }

    By ShuffleAllBtn = By.xpath("//*[@id='queueWrapper']/header/div[3]/span/button[1]");
    public CurrentQPage ShuffleAllBtn () {
        click(ShuffleAllBtn);
        return this;
    }
    By ClearBtn = By.xpath("//*[@id='queueWrapper']/header/div[3]/span/button[2]");
    public CurrentQPage ClearBtn () {
        click(ClearBtn);
        return this;
    }
    By ClearPageMsg = By.xpath("//*[@id='queueWrapper']/div/div/div/span/a");

    public String getClearPageMsg() {
        return findElement(ClearPageMsg).getText();
    }

}
