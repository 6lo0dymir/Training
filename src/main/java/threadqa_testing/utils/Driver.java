package threadqa_testing.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;

import java.time.*;

public class Driver {

    private static WebDriver driver;

    /**
     * Приватный конструктор
     */
    private Driver() {
    }

    /**
     * Создаёт или возвращает текущий экземпляр WebDriver.
     *
     * @param browserName "chrome", "firefox", "edge"
     * @return WebDriver
     */
    public static WebDriver getDriver(String browserName) {
        if (driver != null) {
            return driver;
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
     * Создаёт или возвращает текущий экземпляр WebDriver с поддержкой headless режима.
     *
     * @param browserName "chrome", "firefox", "edge"
     * @param headless    true - браузер без GUI, false - обычный режим
     * @return WebDriver
     */
    public static WebDriver getDriver(String browserName, boolean headless) {
        if (driver != null) {
            return driver;
        }

        switch (browserName.toLowerCase().trim()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("--headless");
                    firefoxOptions.addArguments("--window-size=1920,1080");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless) {
                    edgeOptions.addArguments("--headless=new");
                    edgeOptions.addArguments("--window-size=1920,1080");
                }
                driver = new EdgeDriver(edgeOptions);
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