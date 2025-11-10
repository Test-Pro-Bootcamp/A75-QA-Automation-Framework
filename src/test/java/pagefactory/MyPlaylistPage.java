package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void clickPlaylist(){
        click(firstPlaylist);
    }
    public String playlistHeader(){
        return waitForElementText(playlistHeader);
    }

}
