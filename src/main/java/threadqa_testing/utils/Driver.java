package threadqa_testing.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import java.time.Duration;

public class Driver {

    private Driver() {
    }

    /**
     * Всегда создаёт НОВЫЙ экземпляр WebDriver.
     */
    public static WebDriver getDriver(String browserName, boolean headless) {
        WebDriver driver;

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
                throw new IllegalArgumentException("Неизвестный браузер: " + browserName);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();

        return driver;
    }

    /**
     * Перегрузка для обратной совместимости
     */
    public static WebDriver getDriver(String browserName) {
        return getDriver(browserName, false);
    }
}