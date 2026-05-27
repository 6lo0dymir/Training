package base;

import org.testng.annotations.*;
import threadqa_testing.pages.BasePage;
import lombok.*;
import org.openqa.selenium.WebDriver;


import static threadqa_testing.utils.Driver.getDriver;


public class BaseTest {

    protected BasePage basePage;
    protected WebDriver driver;

    @Getter
    private static final String BASE_URL = "https://lms.threadqa.ru/";

    @BeforeMethod
    public void load(){
        String browser = System.getProperty("browser", "chrome");
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));

        switch (browser) {
            case "firefox" -> {
                driver = getDriver("firefox",headless);
                if (!headless) {
                    driver.manage().window().maximize();
                }
            }
            case "chrome" -> {
                driver = getDriver("chrome",headless);
                if (!headless) {
                    driver.manage().window().maximize();
                }
            }
            case "edge" -> {
                driver = getDriver("edge",headless);
                if (!headless) {
                    driver.manage().window().maximize();
                }
            }
            default -> throw new IllegalArgumentException("Unknown browser: " + browser);
        }
        driver.get(BASE_URL);
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
