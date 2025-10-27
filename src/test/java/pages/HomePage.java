package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    private static final By ALL_SONGS_LINK      = By.xpath("//a[@href='#!/songs' and normalize-space(text())='All Songs']");
    private static final By SEARCH_FIELD        = By.cssSelector("input[type='search']");
    private static final By SONGS_TABLE         = By.xpath("//table[@class='items']");
    private static final By PLAY_BTN            = By.xpath("//span[@data-testid='play-btn']");
    private static final By PAUSE_BTN           = By.xpath("//span[@data-testid='pause-btn']");
    private static final By NEXT_BTN            = By.xpath("//*[@data-testid='play-next-btn']");
    private static final By SIDEBAR_PLAYLIST_BTN= By.cssSelector("[data-testid='sidebar-create-playlist-btn']");
    private static final By SIDEBAR_CREATE_BTN  = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    private static final By SIDEBAR_CREATE_INPUT= By.cssSelector("form[name='create-simple-playlist-form'] input[name='name']");
    private static final By DELETE_PLAYLIST_BTN = By.xpath("//button[contains(@class, 'btn-delete-playlist')]");
    private static final By OK_BTN              = By.xpath("//button[contains(@class, 'ok') or contains(text(), 'OK')]");
    private static final By CONFIRM_DIALOG      = By.xpath("//div[contains(@class,'alertify')]//div[contains(@class,'dialog')]");
    private static final By TOAST_SUCCESS       = By.cssSelector(".alertify-logs .success.show");
    private static final By RENAME_INPUT        = By.cssSelector("[data-testid='inline-playlist-name-input']");

    private static By playlistByName(String name) {
        return By.xpath("//section[@id='playlists']//a[normalize-space(text())='" + name + "']");
    }
    private static By sidebarPlaylistByText(String name) {
        return playlistByName(name);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // ---- page readiness ----
    public boolean isLoaded() {
        try {
            waitVisible(ALL_SONGS_LINK);
            return true;
        }
        catch (TimeoutException e) {
            return false;
        }
    }

    // ---- songs ----
    public void clickAllSongsBtn() {
        safeClick(ALL_SONGS_LINK);
    }
    public void searchSong(String song) {
        type(SEARCH_FIELD, song);
    }
    public void selectFirstSong() {
        waitVisible(SONGS_TABLE).click();
    }

    // ---- player ----
    public void clickPlayNext() {
        safeClick(NEXT_BTN);
    }
    public void clickPlay() {
        safeClick(PLAY_BTN);
    }
    public boolean waitUntilPlaying() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PAUSE_BTN)); return true;
        }
        catch (TimeoutException te) {
            return false;
        }
    }

    // ---- playlists ----
    public boolean playlistExists(String name) {
        return !driver.findElements(playlistByName(name)).isEmpty();
    }
    public void openPlaylist(String name) {
        safeClick(playlistByName(name));
    }
    public void createPlaylistIfMissing(String name) {
        if (!playlistExists(name)) {
            waitClickable(SIDEBAR_PLAYLIST_BTN).click();
            waitClickable(SIDEBAR_CREATE_BTN).click();
            WebElement input = waitVisible(SIDEBAR_CREATE_INPUT);
            input.click(); input.clear(); input.sendKeys(name, Keys.ENTER);
            wait.until(ExpectedConditions.visibilityOfElementLocated(playlistByName(name)));
        }
    }
    public void deleteCurrentPlaylist(String name) {
        safeClick(DELETE_PLAYLIST_BTN);
        confirmDeleteIfPrompted();
        waitUntilDeleted(name);
    }
    private void confirmDeleteIfPrompted() {
        WebDriverWait tiny = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            tiny.until(ExpectedConditions.visibilityOfElementLocated(CONFIRM_DIALOG));
            WebElement ok = tiny.until(ExpectedConditions.elementToBeClickable(OK_BTN));
            ok.click();
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.invisibilityOfElementLocated(CONFIRM_DIALOG));
        }
        catch (TimeoutException | StaleElementReferenceException ignored) {
        }
    }
    public void waitUntilDeleted(String name) {
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(TOAST_SUCCESS),
                ExpectedConditions.numberOfElementsToBe(playlistByName(name), 0)
        ));
    }
    public String getNotificationText() {
        try {
            WebElement toast = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(TOAST_SUCCESS));
            return toast.getText().trim();
        }
        catch (TimeoutException e) {
            return "";
        }
    }
    public void renamePlaylist(String oldName, String newName) {
        WebElement item = waitVisible(sidebarPlaylistByText(oldName));
        new org.openqa.selenium.interactions.Actions(driver).moveToElement(item).doubleClick(item).perform();
        WebElement input = waitVisible(RENAME_INPUT);
        input.sendKeys(Keys.CONTROL, "a");
        input.sendKeys(Keys.BACK_SPACE);
        input.sendKeys(newName, Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.and(
                ExpectedConditions.numberOfElementsToBe(sidebarPlaylistByText(oldName), 0),
                        ExpectedConditions.visibilityOfElementLocated(sidebarPlaylistByText(newName))));
    }
}
