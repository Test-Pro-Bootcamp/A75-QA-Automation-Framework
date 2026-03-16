package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author wiles42
 */
public class PlayListPage extends BasePage {
    public PlayListPage(WebDriver givendriver) {
        super(givendriver);
    }

    By firstPlaylist = By.xpath("//section[@id='playlists']//li[3]");
    By newName = By.xpath("//input[@name='name']");
    By successMSG = By.xpath("//div[@class= 'success show']");
    By clickPlaylist = By.cssSelector(".playlist:nth-child(4)");
    By deletePlaylist = By.xpath("//button[@class='del btn-delete-playlist']");
    By okayBtn = By.xpath("//button[@class='ok']");
    By deleteMSG = By.xpath("//div[@class='success show']");

    public void newPlaylistName(String reName) {
        WebElement reNameField = findElement(newName);
        reNameField.sendKeys(Keys.chord(Keys.COMMAND, "A"), Keys.BACK_SPACE);
        reNameField.sendKeys(reName);
        reNameField.sendKeys(Keys.ENTER);
    }

    public void doubleClick() {
        WebElement clickPlayList = findElement(firstPlaylist);
        actions.doubleClick(clickPlayList).perform();
    }

    public String newSuccessShow() {
        return findElement(successMSG).getText();


    }
    public void clickPlaylist() {
        WebElement wilesPlaylist = findElement(clickPlaylist);
        wilesPlaylist.click();
    }
    public void deleteThePlaylist() {
        WebElement deleting = findElement(deletePlaylist);
        deleting.click();
    }
    public void okButton () {
        WebElement okBtn = findElement(okayBtn);
        okBtn.click();
    }
    public String deletedPlaylistMessage() {
        WebElement deletedMessage = findElement(deleteMSG);
        return deletedMessage.getText();
    }

}
