package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

/**
 * @author wiles42
 */
public class FavoritesPage extends BasePage{
    public FavoritesPage(WebDriver givenDriver){
        super(givenDriver);
    }
    By clickFavoritesPage = By.cssSelector("li[class='playlist favorites']");
    By firstSongHeart = By.xpath("(//button[contains(@title,'M33 Project')])[1]");
    By secondSongHeart = By.xpath("(//button[contains(@title, 'Unlike HoliznaCC0')])[1]");
    By thirdSongHeart = By.xpath("(//button[contains(@title, 'Unlike Riqui')])[1]");
    By firstSong = By.xpath("(//td[contains(text(), 'M33 Project')])[1]");
    By secondSong = By.xpath("(//tr[contains(@class,'song-item')])[2]//button[@data-test='like-btn']");
    By thirdSong = By.xpath("(//tr[contains(@class,'song-item')])[3]//button[@data-test='like-btn']");
    By noSongImg = By.cssSelector(".fa.fa-frown-o");
    By likeButtons = By.xpath("//button[@data-test='like-btn'][.//i[@data-test='btn-like-liked']]");

    public void goToFavorites(){
        presenceOfElement(clickFavoritesPage);
    }
    public WebElement noFavoritesImg(){
        return findElement(noSongImg);
    }
    public void unFavoriteAllSongs()  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        List <WebElement> currentList = driver.findElements(likeButtons);
        while(!currentList.isEmpty()) {
            int previousCount = currentList.size();
            WebElement firstBtn = currentList.get(0);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstBtn);

            if(previousCount >1) {
                wait.until(ExpectedConditions.numberOfElementsToBeLessThan(likeButtons, previousCount));
            }
            currentList = driver.findElements(likeButtons);
        }

        }
    public void unHeartFirstSong(){
        presenceOfElement(firstSongHeart);
    }
    public void unHeartSecondSong(){
        presenceOfElement(secondSongHeart);
    }
    public void unHeartThirdSong(){
        presenceOfElement(thirdSongHeart);
    }
    public boolean  firstSongThere() {
        return !driver.findElements(firstSong).isEmpty();
    }
    public boolean  secondSongThere(){
        return !driver.findElements(secondSong).isEmpty();
    }
    public boolean  thirdSongThere(){
        return !driver.findElements(thirdSong).isEmpty();
    }

}

