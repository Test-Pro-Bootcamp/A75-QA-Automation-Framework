package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author wiles42
 */
public class RecentlyPlayedPage extends BasePage{
    public RecentlyPlayedPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (xpath = "//li[@class='playlist recently-played']")
    WebElement clickRecentlyPlayed;
    @FindBy (xpath = "//section[@id='recentlyPlayedWrapper']//h1" )
    WebElement recentlyPlayedHeader;




    public void recentlyPlayedClick (){
            click(clickRecentlyPlayed);
        }
        public String recentlyPlayHeader(){
        return waitForElementText(recentlyPlayedHeader);
    }

}
