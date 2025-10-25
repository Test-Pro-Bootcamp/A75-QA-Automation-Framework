package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver givenDriver) { super(givenDriver);}

    @FindBy(css = "[data-testid='theme-card-violet']")
    WebElement violetTheme;
    //violetTheme = By.xpath("//div[@data-testid='theme-card-violet']");

    @FindBy(css = "data-testid='theme-card-violet'][class='theme selected']")
    WebElement selectedVioletTheme;
    //By selectedVioletTheme = By.xpath("//div[@data-testid='theme-card-violet' and contains(@class,'selected')]");

        public ProfilePage chooseVioletTheme() {
        click((By) violetTheme);
        return this;
    }

    public boolean isVioletThemeSelected() {
        findElement((By) selectedVioletTheme);
        return selectedVioletTheme.isDisplayed();
    }
    }

