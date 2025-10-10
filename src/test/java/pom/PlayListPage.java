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

    public String successShow() {
        WebElement successMsg = findElement(By.xpath("\"//div[@class= 'success show']\""));
        return successMsg.getText();


    }
}
