package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavoritesPage extends BasePage{
    public FavoritesPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By FavoritesMsg = By.xpath("//*[@id='favoritesWrapper']/header/div[2]/h1");

    public String getFavoritesMsg() {
        return findElement(FavoritesMsg).getText();
    }
}
