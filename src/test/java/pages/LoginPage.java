package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By EMAIL    = By.cssSelector("input[type='email']");
    private static final By PASSWORD = By.cssSelector("input[type='password']");
    private static final By SUBMIT   = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void provideEmail(String email)   { type(EMAIL, email); }
    public void providePassword(String pass) { type(PASSWORD, pass); }
    public void clickSubmitBtn()             { safeClick(SUBMIT); }

    // Return HomePage and wait for it to be ready
    public HomePage loginAs(String email, String pass) {
        provideEmail(email);
        providePassword(pass);
        clickSubmitBtn();
        HomePage home = new HomePage(driver);
        // wait for home-loaded condition
        home.isLoaded(); // we call it to block until ready
        return home;
    }
}
