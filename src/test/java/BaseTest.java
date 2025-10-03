import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public String url;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setupBrowser(String baseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //preconditions
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = baseURL;
        naviagionURL(url);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void clickSubmitBtn() {
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitBtn.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void naviagionURL(String URL) {
        //url = "https://qa.koel.app/";
        driver.get(URL);
    }

    public String getAddToPlaylistSuccessMsg() {
        //Alert alert = driver.switchTo().alert();
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();

        //<div class="success show">Added 1 song into "Test Pro Playlist."</div>
    }

    public void choosePlaylist() {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"));
        playlist.click();
    }

    public void createPlaylist(String newlist) {
        WebElement newplaylist = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/header/div[3]/div/section[2]/form/input"));
        newplaylist.clear();
        newplaylist.sendKeys(newlist);
    }

    public void clickSaveBtn() {
        WebElement saveBtn = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/header/div[3]/div/section[2]/form/button"));
        saveBtn.click();
    }

    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@class='btn-add-to']"));
        addToBtn.click();
    }

    public void selectFirstSong() {
        WebElement Firstsong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        Firstsong.click();
    }

    public void clickViewALLBtn() {
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
    }

    public void searchSong(String song) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(song);
    }

    public void playnextSong() {
        WebElement nextSong = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[1]/i[2]"));
        nextSong.click();
    }

    public void clickPause() {
        WebElement pauseSong = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[1]/span/span[2]/i"));
        pauseSong.click();
    }

    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylist = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[3]/span/button[2]"));
        deletePlaylist.click();
    }

    public void clickOkBtn() {
        WebElement OkBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/nav/button[2]"));
        OkBtn.click();
    }

    public String getDeletePlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

}