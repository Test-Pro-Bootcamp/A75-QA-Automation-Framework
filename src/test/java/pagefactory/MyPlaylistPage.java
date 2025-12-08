package pagefactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

/**
 * @author wiles42
 */
public class MyPlaylistPage extends BasePage{
    public MyPlaylistPage(WebDriver givenDriver){
        super(givenDriver);
    }
    @FindBy (css = ".playlist:nth-child(3)")
    WebElement firstPlaylist;
    @FindBy (xpath = "//section[@id='playlistWrapper']//h1")
    WebElement playlistHeader;
    @FindBy (xpath = "//i[@title='Create a new playlist']")
    WebElement newPlaylistBtn;
    @FindBy (xpath = "//li[@data-testid='playlist-context-menu-create-simple']")
    WebElement newPlaylistSimple;
    @FindBy(xpath = "//input[@name='name']")
    WebElement newPlaylistForm;
    @FindBy (xpath = "//div[@class='success show']")
    WebElement successPlaylistMsg;

    public void clickPlaylist(){
        click(firstPlaylist);
    }
    public String playlistHeader(){
        return waitForElementText(playlistHeader);
    }
    public void clickPlaylistBtn(){
        click(newPlaylistBtn);
    }
    public MyPlaylistPage clickNewPlaylist(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nav[@class='menu playlist-menu']")));
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylistSimple));
        click(newPlaylistSimple);
        return null;
    }
    public MyPlaylistPage inputNewPlaylistName(String playListName){
        newPlaylistForm.sendKeys(playListName);
        newPlaylistForm.sendKeys(Keys.ENTER);
        return this;
    }
    public boolean newPlaylistSuccess(){
        try{
            wait.withTimeout(Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(successPlaylistMsg));
            return true;
        }
        catch (TimeoutException e){
            return false;
        }

    }


}
