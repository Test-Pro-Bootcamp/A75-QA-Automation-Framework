package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CurrentQPage extends BasePage{
    public CurrentQPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //By CurrentQMsg = By.xpath("//*[id='queueWrapper']/header/div[2]/h1/text()");
    By CurrentQMsg = By.xpath("//*[@id='queueWrapper']/header/div[2]/h1");
    public String getCurrentQMsg() {
        return findElement(CurrentQMsg).getText();
    }

}
