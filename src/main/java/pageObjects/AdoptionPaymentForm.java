package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AdoptionPaymentForm {
    private static WebElement element;
    private static Select select;

    public static WebElement name(WebDriver driver) {
        element = driver.findElement(By.id("order_name"));
        return element;
    }

    public static WebElement address(WebDriver driver) {
        element = driver.findElement(By.id("order_address"));
        return element;
    }

    public static WebElement email(WebDriver driver) {
        element = driver.findElement(By.id("order_email"));
        return element;
    }

    public static Select paymentType(WebDriver driver) {
        select = new Select(driver.findElement(By.name("order[pay_type]")));
        return select;
    }

    public static void confirmationButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']"))).click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Couldn't click confirmatiion button, Stale Element");
            driver.findElement(By.linkText("2")).click();
        } catch (TimeoutException e) {
            System.out.println("Couldn't click confirmation button, Timeout");
        }
    }
}