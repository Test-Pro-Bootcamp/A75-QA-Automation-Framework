package pom;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecentlyPlayedPage extends BasePage {
    public RecentlyPlayedPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By RecentlyPlayedMsg = By.xpath("//*[@id='recentlyPlayedWrapper']/header/div[2]/h1");

    public String getRecentlyPlayedMsg() {
        return findElement(RecentlyPlayedMsg).getText();
    }
}
