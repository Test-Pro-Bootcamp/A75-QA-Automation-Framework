package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "input[type='email']")
    private WebElement emailInput;

    @FindBy(css = "input[type='password']")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement submitBtn;

    public LoginPage(WebDriver driver) {
        super(driver); // BasePage calls PageFactory.initElements(driver, this)
    }

    // non-fluent
    public void provideEmail(String email)   { type(emailInput, email); }
    public void providePassword(String pass) { type(passwordInput, pass); }
    public void clickSubmitBtn()             { safeClick(submitBtn); }

    // convenience: do the login and return HomePage when loaded
    public HomePage loginAs(String email, String pass) {
        provideEmail(email);
        providePassword(pass);
        clickSubmitBtn();
        HomePage home = new HomePage(driver);
        home.isLoaded();  // blocks until a home-unique element is visible
        return home;
    }

    // optional fluent style
    public LoginPage withEmail(String email){ type(emailInput, email); return this; }
    public LoginPage withPassword(String p){ type(passwordInput, p); return this; }
    public HomePage submitExpectHome(){ safeClick(submitBtn); HomePage h=new HomePage(driver); h.isLoaded(); return h; }
}
