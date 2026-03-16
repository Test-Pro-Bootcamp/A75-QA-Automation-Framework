package pagefactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author wiles42
 */
public class SearchPage extends BasePage {
    public SearchPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (xpath = "//input[@type='search']")
    WebElement searchInput;
    @FindBy (xpath = "//span[@class='details' and contains(text(),'Epic Song')]")
    WebElement searchResult;
    @FindBy (xpath = "//section[@class='artists']//p" )
    WebElement artistResult;
    @FindBy (xpath = "//section[@class='albums']//p")
    WebElement albumResult;
    @FindBy (xpath = "//section[@class='songs']//p")
    WebElement emptysongResult;
    @FindBy(xpath = "//section[@class='songs']//span[@class='details']")
    WebElement populatedSongResult;

    public void clickSearch (){
        searchInput.click();
    }

    public void inputSearch (String Song){
        searchInput.click();
        searchInput.sendKeys(Song);

    }
    public void clearSearch(){
        searchInput.clear();
    }
    public boolean searchEmpty(){
        return searchInput.getAttribute("value").isEmpty();
        
    }
    public void keyClearSearch(){
        searchInput.click();
        searchInput.sendKeys(Keys.COMMAND,"A");
        searchInput.sendKeys(Keys.DELETE);
    }
    public String artistFound (){
        wait.until(ExpectedConditions.visibilityOf(artistResult));
        return artistResult.getText().trim();
    }
    public String albumFound (){
        wait.until(ExpectedConditions.visibilityOf(albumResult));
        return albumResult.getText().trim();
    }
    public String noSongFound (){
        wait.until(ExpectedConditions.visibilityOf(emptysongResult));
        return emptysongResult.getText().trim();

    }
    public String songFound (){
        wait.until(ExpectedConditions.visibilityOf(populatedSongResult));
        return populatedSongResult.getText().trim();
    }
}
