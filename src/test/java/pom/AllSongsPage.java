package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllSongsPage extends BasePage {
    public AllSongsPage(WebDriver givenDriver){
        super(givenDriver);
    }
    By firstSong = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By playOption = By.cssSelector("li.playback");
    //By allSongsMsg = By.xpath("//*[@id='songsWrapper/]/header/div[2]/h1/text()");
    By allSongsMsg = By.xpath("//*[@id='songsWrapper']/header/div[2]/h1");

    public String getallSongsMsg() {
        return findElement(allSongsMsg).getText();
    }
    public void contextClickFirstSong() {
        actions.contextClick(findElement(firstSong)).perform();
    }
    public void choosePlayOption() {
        findElement(playOption).click();
    }
    By ShuffleAllBtn = By.xpath("//*[@id='songsWrapper']/header/div[3]/span/button[1]");
    //*[@id="songsWrapper"]/header/div[3]/span/button[1]
    public void ShuffleAllBtn () {
        actions.click(findElement(ShuffleAllBtn)).perform();
    }
}
