package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //By userAvatarIcon = By.cssSelector("img.avatar");
    By userAvatarIcon = By.xpath ("//*[@id=\"userBadge\"]/a[1]/img");
    By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistNameField = By.cssSelector("[name='name']");
    By playButton = By.cssSelector(".fa.fa-bars");

    //xpath("//img[@class='avatar']"

  /*  public void doubleClickPlaylist() {
        doubleClick(firstPlaylist);
    }*/

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }

    public String getRenamePlaylistSuccessMsg() {
        return findElement(renamePlaylistSuccessMsg).getText();
    }

    /*public void hoverPlay() {
       hover(playButton);
    }*/
}
