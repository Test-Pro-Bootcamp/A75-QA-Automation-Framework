package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArtistsPage extends BasePage{
    public ArtistsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By ArtistMsg = By.xpath("//*[@id='artistsWrapper']/header/div[2]/h1");
    //*[@id="artistsWrapper"]/header/div[2]/h1
    public String getArtistsMsg() {
        return findElement(ArtistMsg).getText();
    }
}
