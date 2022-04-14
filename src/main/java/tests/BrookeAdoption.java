package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

public class BrookeAdoption {

    private static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://spartantest-puppies.herokuapp.com/");
        String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.contains("https://spartantest-puppies.herokuapp.com/"));

        PuppyListPage.adoptAPuppyButton(driver);
        PuppyListPage.adoptBrookeButton(driver);
        DogDetailsPage.adoptMeButton(driver);
        AdoptionCompletionPage.addToy(driver);
        AdoptionCompletionPage.addTravel(driver);
        AdoptionCompletionPage.confirmationButton(driver);
        AdoptionPaymentForm.name(driver).sendKeys("Natalia");
        Assert.assertEquals(driver.findElement(By.id("order_name")).getAttribute("value"), "Natalia");

        AdoptionPaymentForm.address(driver).sendKeys("Testing Address");
        Assert.assertEquals(driver.findElement(By.id("order_address")).getAttribute("value"), "Testing Address");

        AdoptionPaymentForm.email(driver).sendKeys("1@1.com");
        Assert.assertEquals(driver.findElement(By.id("order_email")).getAttribute("value"),"1@1.com");

        AdoptionPaymentForm.paymentType(driver).selectByVisibleText("Check");
        Assert.assertEquals(driver.findElement(By.name("order[pay_type]")).getAttribute("value"),"Check");

        AdoptionPaymentForm.confirmationButton(driver);
        PuppyListPage.confirmationOfAdoption(driver);
        driver.quit();
    }
}