package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author wiles42
 */
public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By viewAll = By.cssSelector("button[data-test='view-all-songs-btn']");
    By  clickSong = By.xpath("//section[@id='songResultsWrapper']//td[@class='title']");
    By addBtn = By.cssSelector("button.btn-add-to");
    By addToPlaylist = By.xpath("//section[@id= 'songResultsWrapper']//li[contains(text(), 'Wiles Playlist')]");

    public void viewSongResults (){
        findElement(viewAll).click();
    }
    public void clickOnSong (){
        findElement(clickSong).click();
    }
    public void addSongBtn (){
        findElement(addBtn).click();
    }
    public void addToNewPlayList (){
        findElement(addToPlaylist).click();
    }
}
