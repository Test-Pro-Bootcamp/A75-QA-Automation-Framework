package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //By userAvatarIcon = By.cssSelector("img.avatar");
    By loginIcon = By.xpath("//*[@id='app']/div/div/form/div[1]/img");
    By logoutBtn = By.xpath("//*[@id='userBadge']/a[2]");
    By aboutBtn = By.xpath("//*[@id='mainHeader']/div[2]/button");
    By userAvatarIcon = By.xpath ("//*[@id='userBadge']/a[1]/img");
    By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistNameField = By.cssSelector("[name='name']");
    By playButton = By.cssSelector(".fa.fa-bars");
    //By homeName1 = By.cssSelector("[name='How's life, Felicia?']");
    By searchfld = By.xpath("//*[@id='searchForm']/input");
    By homeName = By.xpath("//*[@id='homeWrapper']/header");
    //*[@id='homeWrapper']/header/div[2]/h1
    //*[@id="homeWrapper"]/header
    By mostPlayedLbl = By.xpath("//*[@id='homeWrapper']/div/div[1]/section[1]/h1");
    By recentlyPlayedLbl = By.xpath("//*[@id='homeWrapper']/div/div[1]/section[2]/h1");
    By viewAllBtn = By.xpath("//*[@id='homeWrapper']/div/div[1]/section[2]/h1/button");
    By recentlyAddedLbl = By.xpath("//*[@id='homeWrapper']/div/section[1]/h1");
    By topArtistsLbl = By.xpath("//*[@id='homeWrapper']/div/section[2]/h1");
    By topAlbumsLbl = By.xpath("//*[@id='homeWrapper']/div/section[3]/h1");
    By newPlaylistBtn = By.xpath("//*[@id='playlists']/h1/i");
    By favoritesBtn = By.xpath("//*[@id='playlists']/ul/li[1]/a");
    By playlistRecentlyplayedBtn = By.xpath("//*[@id='playlists']/ul/li[2]/a");
    By playlistNewPlaylistBtn = By.xpath("//*[@id='playlists']/ul/li[3]/a");
    By profileBtn = By.xpath("//*[@id='userBadge']/a[1]/span");
    By aboutCloseBtn = By.xpath("//*[@id='mainWrapper']/div/div/footer/button");
    //By aboutCloseBtn = By.cssSelector("[name='Close']");
    //*[@id="mainWrapper"]/div/div/footer/button
    
    //*[@id="playlists"]/ul/li[2]/a
  /*  public void doubleClickPlaylist() {
        doubleClick(firstPlaylist);
    }*/

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }

    public WebElement getLoginAvatar() {
        return findElement(loginIcon);
    }

    public WebElement getLogoutAvatar() {
        return findElement(logoutBtn);
    }

    public WebElement getProfileBtn() {
        return findElement(profileBtn);
    }

    public WebElement getAboutAvatar() {
        return findElement(aboutBtn);
    }

    public void clickAboutBtn() {findElement(aboutBtn).click();}

    public void clickAboutClose () {findElement(aboutCloseBtn).click();}

    public WebElement getPlaylist () {
        return findElement(newPlaylistBtn);
    }

    public WebElement getFavorites() {
        return findElement(favoritesBtn);
    }

    public WebElement getplaylistRecentlyplayedBtn() {
        return findElement(playlistRecentlyplayedBtn);
    }

    public WebElement getNewPlaylistBtn() {
        return findElement(playlistNewPlaylistBtn);
    }
    public WebElement getViewAll () {
        return findElement(viewAllBtn);
    }

    public WebElement getSearchFld () {
        return findElement(searchfld);
    }

    public String getRenamePlaylistSuccessMsg() {
        return findElement(renamePlaylistSuccessMsg).getText();
    }

    public String getHomeName() {
        return findElement(homeName).getText();
    }

    public String getMostPlayedLbl () {
        return findElement(mostPlayedLbl).getText();
    }
    public String getRecentlyPlayedLbl () {
        return findElement(recentlyPlayedLbl).getText();
    }

    public String getRecentlyAddedLbl () {
        return findElement(recentlyAddedLbl).getText();
    }
    public String getTopArtistsLbl () {
        return findElement(topArtistsLbl).getText();
    }
    public String getTopAlbumsLbl () {
        return findElement(topAlbumsLbl).getText();
    }

    /*public void hoverPlay() {
       hover(playButton);
    }*/
}
