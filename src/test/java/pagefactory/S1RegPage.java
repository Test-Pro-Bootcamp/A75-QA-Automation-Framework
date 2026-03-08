package pagefactory;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author wiles42
 */
public class S1RegPage extends BasePage {
    public S1RegPage (WebDriver givenDriver){
        super(givenDriver);
    }
    @FindBy (css = "input[type='email']")
    WebElement emailInput;
    @FindBy (css = "input[type='submit']")
    WebElement sbmitBtn;
    @FindBy (css = "div.messages")
    WebElement successfulMsg;

    public S1RegPage enterEmail (String email){
        emailInput.sendKeys(email);
        return this;
    }
    public S1RegPage clickSbMit(){
        sbmitBtn.click();
        return this;
    }
    public String validationErrMsg(){
        wait.until(driver -> !emailInput.getAttribute("validationMessage").isEmpty());
        return emailInput.getAttribute("validationMessage");
    }
    public boolean successMessage(){
        return wait.until(ExpectedConditions.visibilityOf(successfulMsg)).isDisplayed();

    }


}
