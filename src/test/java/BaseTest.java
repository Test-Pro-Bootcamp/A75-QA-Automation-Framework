import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
public class BaseTest {
    public WebDriver driver;
    public String url;
    WebDriverWait wait;
    Actions actions;


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void setupBrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        //Preconditions
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = BaseURL;
        navigatetoURL(url);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public void submitBtn() throws InterruptedException {
        //WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitBtn.click();
        Thread.sleep(2000);

    }

    public void providePassword(String password) {
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
       WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.sendKeys(password);
    }

    public void provideEmail(String  email) {
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void navigatetoURL(String URL) {
        //url = "https://qa.koel.app";
        driver.get(URL);
    }

    //homework17
    public String successShow() {
     //WebElement notification = driver.findElement(By.xpath("//div[@class= 'success show']"));
     WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'success show']")));
     return   notification.getText();
    }

    public void addToPlaylist() {
    // WebElement addToPlaylist = driver.findElement(By.xpath("//section[@id= 'songResultsWrapper']//li[contains(text() , 'Wiles Playlist')]"));
        WebElement addToPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id= 'songResultsWrapper']//li[contains(text(), 'Wiles Playlist')]")));
     addToPlaylist.click();
    }

    public void addToBtn() {
        //WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        WebElement addTo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-add-to")));
        addTo.click();
    }

    public void clickSong() {
        //WebElement clickSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//td[@class='title']"));
        WebElement clickSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//td[@class='title']")));
        clickSong.click();
    }

    public void viewAll() {
       // WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        WebElement viewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test='view-all-songs-btn']")));
        viewAll.click();
    }

    public void searchSong(String song) {
       // WebElement search = driver.findElement(By.xpath("//input[@type= 'search']"));
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type= 'search']")));
        search.clear();
        search.sendKeys(song);
    }

    //homework18
    public boolean pauseBtn() {
        //WebElement pauseButton = driver.findElement(By.xpath("//footer[@id= 'mainFooter']//span[@class= 'pause']"));
        WebElement pauseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer[@id= 'mainFooter']//span[@class= 'pause']")));

        return true;
    }

    public void playBtn() {
        //WebElement playButton = driver.findElement(By.xpath("//footer[@id= 'mainFooter']//span[@class= 'play']"));
        WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer[@id= 'mainFooter']//span[@class= 'play']")));
        playButton.click();
    }

    public void nextBtn() {
      // WebElement nextSong = driver.findElement(By.xpath("//footer[@id= 'mainFooter']//i[@title= 'Play next song']"));
        WebElement nextSong = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//footer[@id='mainFooter']//i[@title='Play next song']")));
        nextSong.click();
    }

    // deletePlaylist homework19
    public String deletedPlaylistMessage() {
       // WebElement deletedMessage = driver.findElement(By.xpath("//div[@class='success show']"));
        WebElement deletedMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='success show']")));
        return deletedMessage.getText();
    }

    public void deletethePlaylist() throws InterruptedException {
        //WebElement deletePlaylist = driver.findElement(By.xpath("//button[@class= 'del btn-delete-playlist']"));
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        deletePlaylist.click();
    }
    public void okButton () {
        WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ok']")));
        okBtn.click();
    }

    public void clickPlaylist() {
        //WebElement wilesplaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        WebElement wilesPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        wilesPlaylist.click();
    }

    public void newPlaylistName(String newName ) {
       WebElement reNameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']")));
       reNameField.sendKeys(Keys.chord(Keys.COMMAND, "A"), Keys.BACK_SPACE);
       reNameField.sendKeys(newName);
       reNameField.sendKeys(Keys.ENTER);

    }

    public void doubleClick() {
        WebElement existingPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li[3]")));
        actions.doubleClick(existingPlaylist).perform();
    }
}