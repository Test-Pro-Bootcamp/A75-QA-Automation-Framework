package pagefactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author wiles42
 */
public class InfoPanelPage extends BasePage {
    @FindBy(xpath = "//button[@title='View song information']")
    WebElement infoBtn;
    @FindBy(xpath = "//button[@class='control text-uppercase active']")
    WebElement infoPageOpen;
    @FindBy (xpath ="//button[contains(@class,'control') and contains(@class,'text-uppercase')]" )
    WebElement infoPageClosed;
    @FindBy(xpath = "//button[@id='extraTabLyrics']")
    WebElement lyricsTab;
    @FindBy(xpath = "//button[@id='extraTabArtist']")
    WebElement artistTab;
    @FindBy(xpath = "//button[@id='extraTabAlbum']")
    WebElement albumTab;
    @FindBy(xpath = "//button[@title='Shuffle all songs by Unknown Artist']")
    WebElement artistShuffle;
    @FindBy(xpath = "//article[@id='lyrics']")
    WebElement getLyricsTab;
    @FindBy(xpath = "//section[@id='extra']")
    WebElement infoPanel;
    @FindBy(xpath = "//article[@class='artist-info sidebar']")
    WebElement artistName;
    @FindBy (xpath ="(//h1[@class='name']/span)[2]" )
    WebElement albumName;
    @FindBy (css = "main span.cover:has(a.control-play)")
    WebElement albumCover;
    @FindBy (xpath = "(//td[@class='title'])[1]")
    WebElement songTitle;
    @FindBy (css = "button.shuffle.control[title*='Unknown Album']")
    WebElement albumShuffle;

    public InfoPanelPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void clickInfoPanel() {
        wait.until(ExpectedConditions.visibilityOf(infoBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click", infoBtn);
        wait.until(ExpectedConditions.visibilityOf(infoPanel));

    }

    public boolean infoPanelDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(infoPageOpen));
        return true;
    }
    public boolean closeInfoPanelIfOpen() {
        // Wait until the button exists (in either state)
        wait.until(ExpectedConditions.visibilityOf(infoPageClosed));

        // If the panel is active, click to close it
        if(infoPageClosed.getAttribute("class").contains("active")) {
            infoPageClosed.click();

            // Wait until the "active" class disappears
            wait.until(ExpectedConditions.not(
                    ExpectedConditions.attributeContains(infoPageClosed, "class", "active")
            ));
        }

        // Return true if panel is closed (not active)
        return !infoPageClosed.getAttribute("class").contains("active");
    }


    public void clickLyricsTab() {
        click(lyricsTab);
        wait.until(ExpectedConditions.visibilityOf(lyricsTab));
    }

    public String getLyrics() {
        wait.until(ExpectedConditions.visibilityOf(getLyricsTab));
        return getLyricsTab.getText().trim();
    }

    public String clickOnArtistTab() {
        click(artistTab);
        wait.until(ExpectedConditions.visibilityOf(artistName));
        return artistName.getText();
    }
    public String getAlbumName() {
         click(albumTab);
        wait.until(ExpectedConditions.visibilityOf(albumName));
    return albumName.getText();
    }
    public boolean albumCoverDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(albumCover));

        return albumCover.isDisplayed();

    }
    public String getFirstSong(){
       return songTitle.getText();

    }
    public String getSecondSong(){
        click(albumShuffle);
        return songTitle.getText();
    }
    public String getArtistSecondSong(){
        wait.until(ExpectedConditions.elementToBeClickable(artistShuffle));
        click(artistShuffle);
        return songTitle.getText();
    }

    public void clickAlbumShuffle(){
        wait.until(ExpectedConditions.visibilityOf(albumShuffle));
        click(albumShuffle);
    }
    public void clickArtistShuffle(){
       wait.until(ExpectedConditions.visibilityOf(artistShuffle));
        click(artistShuffle);
    }
}
