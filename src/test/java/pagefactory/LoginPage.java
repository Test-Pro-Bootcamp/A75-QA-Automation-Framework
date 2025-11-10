package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author wiles42
 */
public class LoginPage extends BasePage {
    @FindBy(css = "input[type='email']")
    WebElement emailField;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;
    @FindBy(css = "a[href='registration']")
    WebElement registrationLink;
    @FindBy(xpath = "//a[@title='Log student out']")
    WebElement logOut;
    @FindBy(xpath = "//div[@id='nprogress']")
    WebElement redHighlight;
    @FindBy(xpath = "//a[@title='Log student out']")
    WebElement logOutBtn;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        submitBtn.click();
        return this;
    }

    public LoginPage clickReg() {
        registrationLink.click();
        return null;
    }

    public LoginPage logout() {
        click(logOut);
        return null;
    }

    public boolean redError() {
        wait.until(ExpectedConditions.visibilityOf(redHighlight));
        return true;
    }

    public boolean logOutBtnVisible() {
        wait.until(ExpectedConditions.visibilityOf(logOutBtn));
        return true;
    }
}
