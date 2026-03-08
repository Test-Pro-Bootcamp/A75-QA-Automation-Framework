package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author wiles42
 */
public class ArtistsPage extends BasePage{
    public ArtistsPage(WebDriver givenDriver) {
        super(givenDriver);
}
    @FindBy (xpath = "//a[@href='#!/artists']")
    WebElement artistPage;
    @FindBy (xpath = "//section[@id='artistsWrapper']// h1" )
    WebElement artistHeader;

    public void clickArtistPage (){
        click(artistPage);
    }

    public String getArtistHeaderText (){
        return waitForElementText(artistHeader);
    }


}
