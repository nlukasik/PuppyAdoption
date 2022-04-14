package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class PuppyListPage {

    public static void adoptAPuppyButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.name("adopt-a-puppy"))).click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Couldn't click Adopt a Puppy, Stale Element");
            driver.findElement(By.name("adopt-a-puppy")).click();
        } catch (TimeoutException e) {
            System.out.println("Couldn't click Adopt a Puppy, Timeout");
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("https://spartantest-puppies.herokuapp.com/"));
    }

    public static void PaginationSecondPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("2"))).click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Couldn't change page to second, Stale Element");
            driver.findElement(By.linkText("2")).click();
        } catch (TimeoutException e) {
            System.out.println("Couldn't change page to second, Timeout");
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("https://spartantest-puppies.herokuapp.com/agency?page=2"));

    }

    public static void adoptBrookeButton(WebDriver driver) {
        List<WebElement> puppyList = driver.findElements(By.cssSelector(".rounded_button"));
        try {
            puppyList.get(0).click();
        } catch (NoSuchElementException e) {
            System.out.println("Couldn't locate button");
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("https://spartantest-puppies.herokuapp.com/puppies/"));
    }

    public static void adoptSparkyButton(WebDriver driver) {
        List<WebElement> puppyList = driver.findElements(By.cssSelector(".rounded_button"));
        try {
            puppyList.get(0).click();
        } catch (NoSuchElementException e) {
            System.out.println("Couldn't locate button");
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("https://spartantest-puppies.herokuapp.com/puppies/"));
    }

    public static void randomPuppy(WebDriver driver) {
        List<WebElement> puppyList = driver.findElements(By.cssSelector(".rounded_button"));
        int i;
        int min = 0;
        int max = 3;
        i = (int) ((Math.random() * (max - min)) + min);
        try {
            puppyList.get(i).click();
        } catch (NoSuchElementException e) {
            System.out.println("Couldn't locate Adopt button");
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("https://spartantest-puppies.herokuapp.com/puppies/"));
    }

    public static void confirmationOfAdoption(WebDriver driver) {
        String confirmation = driver.findElement(By.xpath("//p[contains(text(),\"Thank you for adopting a puppy\")]")).getText();
        Assert.assertEquals(confirmation, "Thank you for adopting a puppy!");
    }
}