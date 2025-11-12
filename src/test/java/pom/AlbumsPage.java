package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlbumsPage extends BasePage{
    public AlbumsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //By AlbumsMsg = By.xpath("//*[@id='albumsWrapper']/header/div[2]/h1)");
    By AlbumsMsg = By.xpath("/html/body/div/div/div[1]/section[1]/section[4]/header/div[2]/h1");

    public String getAlbumsMsg() {
        return findElement(AlbumsMsg).getText();
    }
}
