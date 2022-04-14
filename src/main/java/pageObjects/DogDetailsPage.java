package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DogDetailsPage {

    public static void adoptMeButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value=\"Adopt Me!\"]"))).click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Couldn't change page to second, Stale Element");
            driver.findElement(By.linkText("2")).click();
        } catch (TimeoutException e) {
            System.out.println("Couldn't change page to second, Timeout");
        }
        String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.contains("https://spartantest-puppies.herokuapp.com/carts/"));
    }
}