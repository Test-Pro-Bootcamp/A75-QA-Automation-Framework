package pagefactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * @author wiles42
 */
public class S1ProfilePrefPageCss extends BasePage {
    public S1ProfilePrefPageCss(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "a[href^='/#!/profile'")
    WebElement goToPrefPage;
    @FindBy (css = "input[name~= 'current_password']")
    WebElement crtPassword;
    @FindBy (css = "input[name~= 'new_password']")
    WebElement nwPass;
    @FindBy (css = "div[class~= 'error']")
    WebElement errMSG;
    @FindBy(css = "button[class~='btn-submit']")
    WebElement prefBtnSave;
    @FindBy (css = "div[class~= 'success']")
    WebElement sccssMsg;
    @FindBy (css = "a[class~='logout']")
    WebElement lgOtcss;
    By logoutBy = new By.ByCssSelector("a.logout");

   public S1ProfilePrefPageCss clkProfPge (){
       wait.until(ExpectedConditions.elementToBeClickable(goToPrefPage));
       goToPrefPage.click();
       return this;
   }
    public S1ProfilePrefPageCss currentPassword(String currentPassword){
        crtPassword.sendKeys(currentPassword);
        crtPassword.sendKeys(Keys.ENTER);
        return this;

    }
    public S1ProfilePrefPageCss newPassword(String newPassword){
        nwPass.sendKeys(newPassword);
        nwPass.sendKeys(Keys.ENTER);
        return this;
    }
    public S1ProfilePrefPageCss clkSave (){
        prefBtnSave.click();
        return this;
    }
    public boolean successMsg() {
        wait.until(ExpectedConditions.visibilityOf(sccssMsg));
        return true;
    }
    public boolean errMsg() {
        wait.until(ExpectedConditions.visibilityOf(errMSG));
        return true;
    }
    public boolean lgInPrefPage(){
        String prefURl = "https://qa.koel.app/#!/profile";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(prefURl));
        return true;
    }
    public S1ProfilePrefPageCss logOut(){
       waitForToastToDisappear();
       wait.withTimeout(Duration.ofSeconds(15)).ignoring(StaleElementReferenceException.class)
               .until(ExpectedConditions.elementToBeClickable(logoutBy)).click();
       return this;

    }
    public void waitForToastToDisappear() {
        By toast = By.cssSelector(".success");

        wait.until(driver -> {
            List<WebElement> toasts = driver.findElements(toast);
            if (toasts.isEmpty()) {
                return true;
            }
            return toasts.stream().allMatch(t -> !t.isDisplayed());
        });
    }



}
