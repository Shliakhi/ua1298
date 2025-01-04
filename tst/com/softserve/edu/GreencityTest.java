package com.softserve.edu;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreencityTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void positiveRegistrationTest() {
        driver.get("https://www.greencity.cx.ua/");
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(806, 690));

        // Очікування, поки кнопка реєстрації стане клікабельною
        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("app-header:nth-child(1) .header_sign-up-link:nth-child(4) span:nth-child(1)")));
        registerButton.click();

        // Очікування, поки поле електронної пошти стане видимим
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        driver.findElement(By.id("email")).sendKeys("icf28767@msssg.com");

        driver.findElement(By.id("firstName")).sendKeys("Hey1");

        // Очікування, поки поле паролю стане видимим
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordField.sendKeys("Anna$5685-ANNA");

        driver.findElement(By.id("repeatPassword")).sendKeys("Anna$5685-ANNA");

        // Очікування, поки кнопка відправки стане клікабельною
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ubsStyle")));
        submitButton.click();

        // Додайте перевірки для успішної реєстрації
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-header")));
        assertEquals("Ви успішно зареєструвалися на цьому сайті. Підтвердьте свою адресу електронної пошти у своїй поштовій скриньці", driver.findElement(By.cssSelector(".modal-header")).getText());
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}