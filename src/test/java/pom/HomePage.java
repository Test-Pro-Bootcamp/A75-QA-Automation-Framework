package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    By userAvatarIcon = By.cssSelector("img.avatar");
    By searchSong = By.xpath("//input[@type= 'search']");
    By nextBtn = By.xpath("//footer[@id='mainFooter']//i[@title='Play next song']");
    By playBtn = By.xpath("//footer[@id= 'mainFooter']//span[@class= 'play']");
    By pauseBtn = By.xpath("//footer[@id= 'mainFooter']//span[@class= 'pause']");
    public WebElement getUserAvatar(){

        return findElement(userAvatarIcon);
    }

    public void searchNewSong (String song){
        WebElement searchForNewSong = findElement(searchSong);
        searchForNewSong.clear();
        searchForNewSong.sendKeys(song);


    }
    public void clickNextBtn(){
        presenceOfElement(nextBtn);

    }
    public void clickPlay(){
        findElement(playBtn).click();
    }
    public boolean pauseBtnShowing(){
        findElement(pauseBtn);
        return true;

    }





}
