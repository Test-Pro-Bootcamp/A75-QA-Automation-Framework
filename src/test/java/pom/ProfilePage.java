package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //By CurrentPwd = By.cssSelector("input[name='current_password'|input[type='password']");
    By CurrentPwd = By.cssSelector("input[name='current_password']");

    //By NewPwd = By.cssSelector("input[name='new_password'|'type='password']");
    By NewPwd = By.cssSelector("input[name='new_password']");

    By saveBtn = By.xpath("//*[@id='profileWrapper']/div/form/div[5]/button");

    //By ProfileUpdatedMsg = By.cssSelector("Profile updated");
    By ProfileUpdatedMsg = By.xpath("//*[@id='profileWrapper']/header/div[2]/h1");

   /* @FindBy(css = "[id='inputProfileCurrentPassword']")
    WebElement CurrentPwd;

    @FindBy(css = "[id='inputProfileNewPassword']")
    WebElement NewPwd;

    @FindBy(css = "[id='profileWrapper/div/form/div[5]/button']")
    WebElement saveBtn;
*/
    @FindBy(css = "[data-testid='theme-card-violet']")
    WebElement violetTheme;
    //violetTheme = By.xpath("//div[@data-testid='theme-card-violet']");

    @FindBy(css = "data-testid='theme-card-violet'][class='theme selected']")
    WebElement selectedVioletTheme;
    //By selectedVioletTheme = By.xpath("//div[@data-testid='theme-card-violet' and contains(@class,'selected')]");

    public void providePwd(String password) {
        findElement(CurrentPwd).sendKeys(password);
    }

    public void provideNewPwd(String Newpwd) {
        findElement(NewPwd).sendKeys(Newpwd);
    }

    public String getProfileUpdatedMsg() {
        return findElement(ProfileUpdatedMsg).getText();
    }

    public ProfilePage chooseVioletTheme() {
        click((By) violetTheme);
        return this;
    }

    public boolean isVioletThemeSelected() {
        findElement((By) selectedVioletTheme);
        return selectedVioletTheme.isDisplayed();
    }

    public void clickSave() {
        findElement(saveBtn).click();
    }
}

