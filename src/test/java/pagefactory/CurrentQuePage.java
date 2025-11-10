package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wiles42
 */
public class CurrentQuePage extends BasePage {
    @FindBy(xpath = "//a[@href='#!/queue']")
    WebElement clickQue;
    @FindBy(xpath = "//div[@class='heading-wrapper'] //h1[contains(text(), 'Current Que')]")
    WebElement queHeader;

    public CurrentQuePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void clickQue() {
        click(clickQue);
    }

    public String getQueHeaderText (){
        return waitForElementText(queHeader);
    }


}
