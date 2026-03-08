package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author wiles42
 */
public class S1LoginPageCss extends BasePage {
    public S1LoginPageCss(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "input[type= 'email']")
    WebElement cssEmail;
    @FindBy(css = "input[type= 'password']")
    WebElement cssPasswrd;
    @FindBy(css = "button[type= 'submit']")
    WebElement cssSubmit;
    @FindBy(css = "form[class~= 'error']")
    WebElement cssErr;
    @FindBy (css = "a[href='registration']" )
    WebElement regPageLink;

    public S1LoginPageCss giveEmail(String email) {
        cssEmail.sendKeys(email);
        return this;
    }

    public S1LoginPageCss givePssWrd(String password) {
        cssPasswrd.sendKeys(password);
        return this;
    }

    public S1LoginPageCss clckSubmt() {
        cssSubmit.click();
        return this;
    }

    public S1LoginPageCss waitforPage() {
        wait.until(ExpectedConditions.visibilityOf(cssEmail));
        return this;
    }
    public boolean redErr(){
        wait.until(ExpectedConditions.visibilityOf(cssErr));
        return true;
    }
    public S1LoginPageCss clickReg (){
        regPageLink.click();
        return this;
    }


}
