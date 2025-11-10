package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author wiles42
 */
public class FavoritesPage extends BasePage{
    public FavoritesPage(WebDriver givenDriver){
        super(givenDriver);
    }
    @FindBy (xpath = "//a[@href='#!/favorites']")
    WebElement clickFavorites;
    @FindBy (xpath = "//section[@id='favoritesWrapper']//h1")
    WebElement favoritesHeader;

public void clickFavorites(){
    click(clickFavorites);
}
public String getFavoritesHeader(){
    return waitForElementText(favoritesHeader);

}
}
