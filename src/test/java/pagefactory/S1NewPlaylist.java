package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class S1NewPlaylist extends BasePage {

    public S1NewPlaylist(WebDriver givenDriver){
        super(givenDriver);
    }

    @FindBy(css = "[data-testid='sidebar-create-playlist-btn']")
    WebElement plusPlaylistbtn;

    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    WebElement newPlaylist;

    @FindBy(xpath = "//input[@name='name']")
    WebElement playlistform;

    @FindBy(css = "div.success.show")
    WebElement playListSuccessMsg;


    public void clickPlayListBtn(){

        WebElement plus = wait.until(ExpectedConditions.elementToBeClickable(plusPlaylistbtn));
        actions.moveToElement(plus).click().perform();
        wait.until(ExpectedConditions.visibilityOf(newPlaylist));
    }

    public void clickNewPlayList(){

        wait.until(ExpectedConditions.elementToBeClickable(newPlaylist));
        newPlaylist.click();
    }

    public S1NewPlaylist enterPlayListName(String name){

        wait.until(ExpectedConditions.visibilityOf(playlistform));

        playlistform.clear();
        playlistform.sendKeys(name);
        playlistform.sendKeys(Keys.ENTER);

        return this;
    }

    public boolean successfulMsg(){

        wait.until(ExpectedConditions.visibilityOf(playListSuccessMsg));
        return playListSuccessMsg.isDisplayed();
    }
}