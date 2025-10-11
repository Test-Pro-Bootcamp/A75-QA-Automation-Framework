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
        navigateToUrl();
    }
    @AfterMethod
    public void tearDown() {
        if(driver != null)
        driver.quit();
    }
    public void navigateToUrl() {
        url = "https://qa.koel.app/";
        driver.get(url);
    }
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
    // Getting specific
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
    //Homework-18 stuff
    private By playBtn  = By.xpath("//span[@data-testid='play-btn']");
    private By pauseBtn = By.xpath("//span[@data-testid='pause-btn']");
    private By nextBtn  = By.xpath("//*[@data-testid='play-next-btn']");

    public void clickPlayNext() {
        driver.findElement(nextBtn).click();
    }

    public void clickPlay() {
        driver.findElement(playBtn).click();
    }

    /** Wait until the player switches to a 'playing' state (Pause visible). */
    public boolean waitUntilPlaying() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(pauseBtn));
            return true;
        } catch (TimeoutException te) {
            return false;
        }
    }
}

