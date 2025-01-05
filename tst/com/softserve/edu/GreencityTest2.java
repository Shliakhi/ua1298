package com.softserve.edu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GreencityTest2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.greencity.cx.ua/#/greenCity");

            // Очікування, поки кнопка реєстрації стане видимою та клікабельною
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".header_sign-up-btn span")));
            signUpButton.click();

            WebElement emailField = driver.findElement(By.id("email"));
            emailField.sendKeys("ghekne@gma.com");

            WebElement firstNameField = driver.findElement(By.id("firstName"));
            firstNameField.sendKeys("Hey12321312312gg5g454456345234123123123123123123123123123123d!!!!@###$$");

            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("129865");

            WebElement repeatPasswordField = driver.findElement(By.id("repeatPassword"));
            repeatPasswordField.sendKeys("129865");

            WebElement submitButton = driver.findElement(By.cssSelector(".submit-button"));
            submitButton.click();

            Thread.sleep(3000); // Для спостереження результату

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}