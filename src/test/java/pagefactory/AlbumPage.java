package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author wiles42
 */
public class AlbumPage extends BasePage{
    @FindBy (xpath = "//a[@href='#!/albums']")
    WebElement clickAlbum;
    @FindBy(xpath ="//section[@id='albumsWrapper'] // h1" )
    WebElement albumHeader;

    public AlbumPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void clickAlbumPage(){
        click(clickAlbum);
    }
    public String getAlbumHeaderText (){
        return waitForElementText(albumHeader);
    }
}
