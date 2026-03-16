package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author wiles42
 */
public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver givenDriver){
        super(givenDriver);
    }
    By selectAllSongsPage = By.cssSelector("a[class= 'songs']");
    By heartFirstSong = By.xpath("(//td[@class = 'favorite'])[1]");
    By heartSecondSong = By.xpath("(//td[@class = 'favorite'])[2]");
    By heartThirdSong = By.xpath("(//td[@class = 'favorite'])[3]");

    public void goToAllSongsPage(){
        presenceOfElement(selectAllSongsPage);
    }
    public void firstSongHear(){
        presenceOfElement(heartFirstSong);
    }
    public void secondSongHeart(){
        presenceOfElement(heartSecondSong);
    }
    public void thirdSongHeart(){
        presenceOfElement(heartThirdSong);
    }
}
