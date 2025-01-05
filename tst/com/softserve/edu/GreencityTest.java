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
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreencityTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Збільшено до 60 секунд
        driver.manage().window().maximize(); // Зробити вікно браузера максимальним
    }

    @Test
    public void positiveRegistrationTest() {
        driver.get("https://www.greencity.cx.ua/#/greenCity");

        // Очікування, поки кнопка реєстрації стане видимою та клікабельною
        WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".header_sign-up-btn span")));
        signUpButton.click();

        // Очікування, поки поле електронної пошти стане видимим
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        driver.findElement(By.id("email")).sendKeys("icf28767@msssg.com");

        driver.findElement(By.id("firstName")).sendKeys("Hey1");

        // Очікування, поки поле паролю стане видимим
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordField.sendKeys("Anna$5685-ANNA");

        driver.findElement(By.id("repeatPassword")).sendKeys("Anna$5685-ANNA");

        // Спроба натискання кнопки через JavaScript (якщо звичайне натискання не працює)
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ubsStyle")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

        // Додайте перевірки для успішної реєстрації
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-header")));
        assertEquals("Ви успішно зареєструвалися на цьому сайті. Підтвердьте свою адресу електронної пошти у своїй поштовій скриньці", driver.findElement(By.cssSelector(".modal-header")).getText());
    }

    @AfterAll
    public static void tearDown() {
        driver.quit(); // Закрити браузер після тесту
    }
}