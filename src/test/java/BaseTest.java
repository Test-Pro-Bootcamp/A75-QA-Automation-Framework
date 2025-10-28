import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.UUID;

public class BaseTest {
    public static WebDriver driver = null;
    Wait<WebDriver> fluentWait;
    public static Actions actions = null;
    public static String url = null;
    public static WebDriverWait wait = null;

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})

    //parallel execution
    public void setupBrowser(String baseURL) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getDriver().manage().window().maximize();

        actions = new Actions(getDriver());
        url = baseURL;
        naviagionURL(url);


        fluentWait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);

    }

   /* //single execution
    public void launchBrowser(String baseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //preconditions
       // driver = new ChromeDriver(options);
        driver = pickBrowser(System.getProperty("browser"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        url = baseURL;
        naviagionURL(url);
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);

    }*/

    @AfterMethod
    public void tearDown() {

        //closeBrowser driver.quit(); //can be used when doing 1 test at a time
        threadDriver.get().close();
        threadDriver.remove();

    }

    public void clickSubmitBtn() {
        WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
       // WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitBtn.click();
    }

    public void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    public void provideCurrentPassword(String password){
        WebElement currentpassword= driver.findElement(By.cssSelector("input[name='current_password']"));
        currentpassword.clear();
        currentpassword.sendKeys(password);
    }

    public String randomName(){
        return UUID.randomUUID().toString().replace("-","");
    }
    public void changeName(String randomname){
        WebElement currentName = driver.findElement(By.cssSelector("[name='name']"));
        currentName.clear();
        currentName.sendKeys(randomname);
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void naviagionURL(String URL) {
        //url = "https://qa.koel.app/";
        //driver.get(URL);
        getDriver().get(URL);
    }

    public String getAddToPlaylistSuccessMsg() {
        //Alert alert = driver.switchTo().alert();
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();

        //<div class="success show">Added 1 song into "Test Pro Playlist."</div>
    }

    public void choosePlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]")));
        playlist.click();
    }

    public void openPlaylist() {
        WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        emptyPlaylist.click();
    }

    public void rightclickPlaylist() {
        WebElement rightclickList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.contextClick(rightclickList).perform();
    }

    public void clickEditPlaylist() {
        WebElement editList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/nav/ul/li[1]")));
        actions.click(editList).perform();
    }

    public void enterList() {
        WebElement renameList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']")));
        renameList.sendKeys(Keys.chord("2", (Keys.COMMAND), Keys.BACK_SPACE));
        renameList.sendKeys(Keys.ENTER);
    }

    public void createPlaylist(String newlist) {
        WebElement newplaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"songsWrapper\"]/header/div[3]/div/section[2]/form/input")));
        newplaylist.clear();
        newplaylist.sendKeys(newlist);
    }

    public void clickSaveBtn() {
        WebElement saveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"songsWrapper\"]/header/div[3]/div/section[2]/form/button")));
        saveBtn.click();
    }

    public void clickAddToBtn() {
        WebElement addToBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//button[@class='btn-add-to']")));
        addToBtn.click();
    }

    public void selectFirstSong() {
        WebElement Firstsong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")));
        Firstsong.click();
    }

    public void clickViewALLBtn() {
        WebElement viewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test='view-all-songs-btn']")));
        viewAll.click();
    }

    public void searchSong(String song) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));
        searchField.clear();
        searchField.sendKeys(song);
    }

    public void playnextSong() {
        WebElement nextSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mainFooter\"]/div[1]/i[2]")));
        nextSong.click();
    }

    public void clickPause() {
        WebElement pauseSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mainFooter\"]/div[1]/span/span[2]/i")));
        pauseSong.click();
    }

    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[3]/span/button[2]")));
        deletePlaylist.click();
    }

    public void clickDelPlaylistBtn() {
        WebElement delemptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[3]/span/button")));
        delemptyPlaylist.click();
    }

    public void clickOkBtn() {
        WebElement OkBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/nav/button[2]")));
        OkBtn.click();
    }

    public String getDeletePlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    public String getRenamePlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
    public WebDriver pickBrowser (String browser) throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://192.168.100.137:4444/";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver();
            case "Explorer":
                WebDriverManager.iedriver().setup();
                return driver = new InternetExplorerDriver();
                //Grid Capable
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-safari":
                caps.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }
    public WebDriver lambdaTest() throws MalformedURLException{
        String hubURL = "Https://hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("dev");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "feliciaclay");
        ltOptions.put("accessKey", "LT_tNSae0ywb8002DXy68cC8mjj9erXDkwQLKh0do89Hwc3JVn");
        ltOptions.put("project", "Untitled");
        ltOptions.put("name", this.getClass().getName());
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }
}