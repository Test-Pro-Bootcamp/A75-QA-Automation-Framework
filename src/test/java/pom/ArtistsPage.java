package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArtistsPage extends BasePage{
    public ArtistsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By ArtistMsg = By.xpath("//*[@id='artistsWrapper']/header/div[2]/h1");
    By firstArtist = By.xpath("//*[@id='artistsWrapper']/div/article[1]/span");

    public String getArtistsMsg() {
        return findElement(ArtistMsg).getText();
    }

    public ArtistsPage choose1stArtist() {
        click(firstArtist);
        //doubleClick((By) firstArtist);
        return this;
    }
}
