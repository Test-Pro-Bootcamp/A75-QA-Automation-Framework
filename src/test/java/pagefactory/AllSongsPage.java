package pagefactory;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author wiles42
 */
public class AllSongsPage extends BasePage {

    @FindBy(xpath = "//a[@href='#!/songs']")
    WebElement clickAllSongs;

    @FindBy(xpath = "//section[@id='songsWrapper']//h1")
    WebElement allSongsHeader;
    @FindBy (xpath = "(//td[@class='title'])[1]")
    WebElement firstSongInList;
    @FindBy (css = "span[data-testid='pause-btn']")
    WebElement pauseBtn;


    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void clickAllSongsPage() {
        click(clickAllSongs);
    }
    public String getAllSongsHeaderText (){
        return waitForElementText(allSongsHeader);
    }
    public void playFirstSong(){
        doubleClick(firstSongInList);
    }
    public boolean pauseBtnVisible() {
         actions.moveToElement(pauseBtn).perform();
        wait.until(ExpectedConditions.visibilityOf(pauseBtn));
            return pauseBtn.isDisplayed();
        }
}

