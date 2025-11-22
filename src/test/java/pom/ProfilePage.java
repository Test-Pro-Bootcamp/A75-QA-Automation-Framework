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

    By ProfileNameFld = By.xpath("//*[@id='inputProfileName']");
    //*[@id="inputProfileName"]

    By ProfileEmailFld = By.cssSelector("input[name='email']");
    //By ProfileEmailFld = By.xpath("//*[@id='inputProfileEmail']");
    //*[@id="inputProfileEmail"]


    By ShowNowChkbox = By.xpath("//*[@id='profileWrapper']/div/div/div[1]/label/input");

    By ConfirmChkbox = By.xpath("//*[@id='profileWrapper']/div/div/div[2]/label/input");

    By ShowTransChkbox = By.xpath("//*[@id='profileWrapper']/div/div/div[3]/label/input");
    //*[@id="profileWrapper"]/div/div/div[3]/label/input

   /* @FindBy(css = "[id='inputProfileCurrentPassword']")
    WebElement CurrentPwd;

    @FindBy(css = "[id='inputProfileNewPassword']")
    WebElement NewPwd;

    @FindBy(css = "[id='profileWrapper/div/form/div[5]/button']")
    WebElement saveBtn;
*/
    //@FindBy(css = "[data-testid='theme-card-violet']")
    //WebElement violetTheme;
    By violetTheme = By.xpath("//*[@id='profileWrapper']/div/section[1]/ul/li[2]/div");
           //"//div[@data-testid='theme-card-violet']");


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
    public void provideName(String Name) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(ProfileNameFld)).clear();
        findElement(ProfileNameFld).sendKeys(Name);
    }

    public void provideEmail(String Email) {

        findElement(ProfileEmailFld).sendKeys(Email);
    }

    public void chooseVioletTheme() {
        findElement(violetTheme).click();
        //click((By) violetTheme);
        //return this;
    }

    public boolean isVioletThemeSelected() {
        findElement((By) selectedVioletTheme);
        return selectedVioletTheme.isDisplayed();
    }

    public void clickSave() {
        findElement(saveBtn).click();
    }
    public void clickShowNow () {findElement(ShowNowChkbox).click();}
    public void clickConfirm () {findElement(ConfirmChkbox).click();}
    public void clickShowTran () {findElement(ShowTransChkbox).click();}
}

