package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    @FindBy (xpath ="//i[@class='fa fa-frown-o']")
    WebElement noFavoritesIcon;
    @FindBy (xpath = "(//table[@class='items'])[2]//td[@class='title']")
    WebElement firstFavorite;
    @FindBy (xpath = "(//table[@class='items'])[2]//td[@class='favorite']")
    WebElement firstFavoriteBtn;


public void clickFavorites(){
    click(clickFavorites);
}
public String getFavoritesHeader(){
    return waitForElementText(favoritesHeader);

}
public Boolean noFavoriteImage (){
    noFavoritesIcon.isDisplayed();
    return true;
}

public String firstFavoriteInList (){
    wait.until(ExpectedConditions.visibilityOf(firstFavorite));
    return firstFavorite.getText().trim();

}
public void clickFirstFavoriteBtn (){
    wait.until(ExpectedConditions.visibilityOf(firstFavoriteBtn));
    firstFavoriteBtn.click();
}
}
