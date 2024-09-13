package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;

    public static WebDriverWait webDriverWait;

    public static void initializeDriver() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Altamash\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64|\\chromedriver.exe");

        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().window().maximize();
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
