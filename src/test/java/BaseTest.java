import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void setupBrowser(String BaseURL) throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = pickBrowser(System.getProperty("browser"));


        //Preconditions
        //driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = BaseURL;
        navigatetoURL(url);
        actions = new Actions(driver);
    }

    public void navigatetoURL(String url) {
        driver.get("https://qa.koel.app/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://192.168.1.155:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();

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


            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);

        }

  /*  // deletePlaylist homework19
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








    //Homework21


  /* public void newPlaylistName(String newName ) {
       WebElement reNameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']")));
       reNameField.sendKeys(Keys.chord(Keys.COMMAND, "A"), Keys.BACK_SPACE);
       reNameField.sendKeys(newName);
       reNameField.sendKeys(Keys.ENTER);

    }

   public void doubleClick() {
        WebElement existingPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li[3]")));
        actions.doubleClick(existingPlaylist).perform();
    } */
    }
}
