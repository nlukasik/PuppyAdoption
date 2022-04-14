package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AdoptionCompletionPage {
    private static WebElement element;

    public static void addCollar(WebDriver driver) {
        element = driver.findElement(By.cssSelector("#collar"));
        if (!element.isSelected()) {
            try {
                element.click();
            } catch (NoSuchElementException e) {
                System.out.println("Couldn't locate Chew Toy");
            }
        }
        Assert.assertEquals(element.isSelected(), Boolean.TRUE);
    }

    public static void addToy(WebDriver driver) {
        element = driver.findElement(By.cssSelector("#toy"));
        if (!element.isSelected()) {
            try {
                element.click();
            } catch (NoSuchElementException e) {
                System.out.println("Couldn't locate Chew Toy");
            }
        }
        Assert.assertEquals(element.isSelected(), Boolean.TRUE);
    }

    public static void addTravel(WebDriver driver) {
        element = driver.findElement(By.cssSelector("#carrier"));
        if (!element.isSelected()) {
            try {
                element.click();
            } catch (NoSuchElementException e) {
                System.out.println("Couldn't locate Chew Toy");
            }
        }
        Assert.assertEquals(element.isSelected(), Boolean.TRUE);
    }

    public static void confirmationButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value=\"Complete the Adoption\"]"))).click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Couldn't click Complete the Adoption button, Stale Element");
            driver.findElement(By.linkText("2")).click();
        } catch (TimeoutException e) {
            System.out.println("Couldn't click Complete the Adoption button, Timeout");
        }
        String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.contains("ttps://spartantest-puppies.herokuapp.com/orders/"));
    }


    public static void adoptAnotherButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value=\"Adopt Another Puppy\"]"))).click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Couldn't click Adopt Another Puppy button, Stale Element");
            driver.findElement(By.linkText("2")).click();
        } catch (TimeoutException e) {
            System.out.println("Couldn't click Adopt Another Puppy button, Timeout");
        }
        String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.contains("ttps://spartantest-puppies.herokuapp.com"));

    }

    public static void collarsAdd(WebDriver driver) {
        List<WebElement> collars = driver.findElements(By.cssSelector("#collar"));
        int l = collars.size();
        for (WebElement collar : collars) {
            collar.click();
            Assert.assertEquals(collar.isSelected(), Boolean.TRUE);
        }

    }

    public static void randomAccessories(WebDriver driver) {
        List<WebElement> accessories = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
        int i;
        int min = 0;
        int max = 3;
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != 3) {
            i = (int) ((Math.random() * (max - min)) + min);
            if (!numbers.contains(i)) {
                numbers.add(i);
            }
        }
        int l = numbers.size();
        for (Integer number : numbers) {
            try {
                accessories.get(number).click();
            } catch (NoSuchElementException e) {
                System.out.println("Couldn't locate Adopt button");
            }
            Assert.assertEquals(accessories.get(number).isSelected(), Boolean.TRUE);
        }
    }
}