package base;

import threadqa_testing.pages.BasePage;
import lombok.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;


import static threadqa_testing.utils.Driver.getDriver;


public class BaseTest {

    protected BasePage basePage;
    protected WebDriver driver;

    @Getter
    private static final String BASE_URL = "https://lms.threadqa.ru/";

    @BeforeClass
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
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
