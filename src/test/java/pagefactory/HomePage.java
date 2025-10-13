package pagefactory;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.*;

public class HomePage extends BasePage {
    @FindBy (xpath = "//section[@id='playlists']//li[3]")
    WebElement firstplaylist;
    @FindBy (xpath = "//input[@name='name']")
    WebElement newName;
    @FindBy (xpath = "//div[@class= 'success show']")
    WebElement successShow;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);


    }
    public void dblClickPlaylist (){
        doubleClick(firstplaylist);

    }
    public void inputName (String Name){

        newName.sendKeys(COMMAND,"A");
        newName.sendKeys(BACK_SPACE);
        newName.sendKeys(Name);
        newName.sendKeys(ENTER);
        
    }
    public String successMessage(){
        successShow.isDisplayed();
        return successShow.getText();
    }
}
