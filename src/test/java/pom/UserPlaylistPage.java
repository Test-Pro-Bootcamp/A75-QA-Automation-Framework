package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPlaylistPage extends BasePage{
    public UserPlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By UserPlaylistMsg = By.xpath("//*[@id='playlistWrapper']/header/div[2]/h1");
    //*[@id="playlistWrapper"]/header/div[2]/h1

    public String getUserPlaylistMsg() {
        return findElement(UserPlaylistMsg).getText();
    }
}
