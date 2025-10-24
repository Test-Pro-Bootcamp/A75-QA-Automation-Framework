import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;


public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String url;

    //Getting Started
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

    //------------------ WAIT helpers ------------------
    private WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private void safeClick(By locator) {
        waitClickable(locator).click();
    }

    //--------------------- URL control -------------------------
    public void navigateToUrl(String baseUrl) {
        this.url = baseUrl;
        driver.get(baseUrl);
    }
    //public void navigateToUrl() {
    //url = "https://qa.koel.app/";
    //driver.get(url);
    //}

//--------------------- LOG IN ------------------------------------

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmitBtn() {
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitBtn.click();
    }
    public void login(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmitBtn();
    }
    //-------------------- SONGS LIST ------------------------
    public void clickAllSongsBtn() {
        driver.findElement(By.xpath("//a[@href='#!/songs' and normalize-space(text())='All Songs']")).click();
    }
    public void searchSong(String song) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(song);
    }
    public void selectFirstSong() {
        WebElement Firstsong = driver.findElement(By.xpath("//table[@class='items']"));
        Firstsong.click();
    }
    //-------------- PLAY Button -----------------------
    private By playBtn  = By.xpath("//span[@data-testid='play-btn']");
    private By pauseBtn = By.xpath("//span[@data-testid='pause-btn']");
    private By nextBtn  = By.xpath("//*[@data-testid='play-next-btn']");

    public void clickPlayNext() {
        driver.findElement(nextBtn).click();
    }
    public void clickPlay() {
        driver.findElement(playBtn).click();
    }
    // Wait until the player switches to a 'playing' state (Pause visible).
    public boolean waitUntilPlaying() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(pauseBtn));
            return true;
        } catch (TimeoutException te) {
            return false;
        }
    }
    //----------------- PLAYLIST -----------------

    private final By sidebarPlaylistBtn = By.cssSelector(
            "[data-testid='sidebar-create-playlist-btn']");
    private final By sidebarCreateBtn = By.cssSelector(
            "[data-testid='playlist-context-menu-create-simple']");
    private final By sidebarCreateInput = By.cssSelector(
            "form[name='create-simple-playlist-form'] input[name='name']");


    private By playlistByName(String name) {
        return By.xpath("//section[@id='playlists']//a[normalize-space(text())='" + name + "']");
    }
    public boolean playlistExists(String name) {
        return !driver.findElements(playlistByName(name)).isEmpty();
    }

    public void openPlaylist(String name) {
        safeClick(playlistByName(name));
    }

    public void createPlaylistIfMissing(String name) {
        if (!playlistExists(name)) {
            // click the + button on the sidebar
            WebElement plus  = wait.until(
                    ExpectedConditions.elementToBeClickable(sidebarPlaylistBtn));
            plus .click();
            //Click New playlist in the context menu
            WebElement newPlaylist  = wait.until(
                    ExpectedConditions.elementToBeClickable(sidebarCreateBtn));
            newPlaylist .click();

            //Type the name and press Enter
            WebElement input = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(sidebarCreateInput));
            input.click();
            input.clear();
            input.sendKeys(name,Keys.ENTER);

            // 3. Wait until the new playlist appears in the sidebar
            wait.until(ExpectedConditions.visibilityOfElementLocated(playlistByName(name)));
        }
    }
    //------------------Delete playlist------------------------------------
    // Red “x PLAYLIST” button at top right
    private final By deletePlaylistBtn = By.xpath(
            "//button[contains(@class, 'btn-delete-playlist')]");
    private final By okBtn = By.xpath(
            "//button[contains(@class, 'ok') or contains(text(), 'OK')]");
    private final By confirmDialog = By.xpath(
            "//div[contains(@class,'alertify')]//div[contains(@class,'dialog')]");

    public void confirmDeleteIfPrompted() {
        WebDriverWait tiny = new WebDriverWait(driver, Duration.ofSeconds(2)); // short, non-blocking
        try {
            // If a dialog appears, handle it
            tiny.until(ExpectedConditions.visibilityOfElementLocated(confirmDialog));
            WebElement ok = tiny.until(ExpectedConditions.elementToBeClickable(okBtn));
            ok.click();
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.invisibilityOfElementLocated(confirmDialog));
        } catch (TimeoutException ignored) {
            // No dialog is fine
        } catch (StaleElementReferenceException ignored) {
            // Dialog closed itself
        }
    }
    private final By toastSel = By.cssSelector(".alertify-logs .success.show");

    public void waitUntilDeleted(String name) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.or(
                        ExpectedConditions.visibilityOfElementLocated(toastSel),
                        ExpectedConditions.numberOfElementsToBe(playlistByName(name), 0)));
    }


    public void deleteCurrentPlaylist(String name) {
        safeClick(deletePlaylistBtn);
        confirmDeleteIfPrompted();
        waitUntilDeleted(name);
    }
    public void deleteConfirmPlaylist() {
        safeClick(okBtn);

    }
    // Wait for the success toast and return its text (or "Erm" if none appears)
    public String getNotificationText() {
        By toastSel = By.cssSelector(".alertify-logs .success.show");
        try {
            WebElement toast = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(toastSel));
            return toast.getText().trim();
        } catch (TimeoutException e) {
            return "";
        }
    }
    //-----------------------Rename playlist-----------------------------------------
    // ==== RENAME PLAYLIST ====

    private By sidebarPlaylistByText(String name) {
        return By.xpath("//section[@id='playlists']//a[normalize-space(text())='" + name + "']");
    }

    // locator for the edit playlist name input
    private final By renameInput = By.cssSelector("[data-testid='inline-playlist-name-input']");

    /*
      Renames a playlist using Actions double click + type + ENTER.
      Waits for edit field, then for the new name to appear in the sidebar
    */

    public void renamePlaylist(String oldName, String newName) {
        // checks if the old playlist exists and is visible in the sidebar
        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(sidebarPlaylistByText(oldName)));

        // Double-click the playlist item to enter edit mode
        new org.openqa.selenium.interactions.Actions(driver)
                .moveToElement(item)
                .doubleClick(item)
                .perform();

        // Wait for the inline rename input then type new name + ENTER
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(renameInput));
        input.sendKeys(Keys.CONTROL, "a");
        input.sendKeys(Keys.BACK_SPACE);
        input.sendKeys(newName, Keys.ENTER);

        //Outcome wait either toast appears OR sidebar shows the new text
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(
                ExpectedConditions.and(ExpectedConditions.numberOfElementsToBe(sidebarPlaylistByText(oldName), 0),
                        ExpectedConditions.visibilityOfElementLocated(sidebarPlaylistByText(newName))));
    }


}

