package threadqa_testing.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;

import java.time.*;

public class Driver {

    private static WebDriver driver;

    /** Приватный конструктор */
    private Driver() {}

    /**
     * Создаёт или возвращает текущий экземпляр WebDriver.
     * @param browserName "chrome", "firefox", "edge"
     * @return WebDriver
     */
    public static WebDriver getDriver(String browserName) {
        if (driver != null) {
            return driver; // уже создан
        }

        switch (browserName.toLowerCase().trim()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();

        return driver;
    }

    /**
     * Закрывает драйвер
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}