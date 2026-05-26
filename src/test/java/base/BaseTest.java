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
    @Parameters ("browser")
    public void load(@Optional("chrome") String browser){
        switch (browser) {
            case "firefox" -> {
                driver = getDriver("firefox");
                driver.manage().window().maximize();
                driver.get(BASE_URL);

            }

            case "chrome" -> {
                driver = getDriver("chrome");
                System.setProperty("webdriver.chrome.args", "--headless=new");
                driver.get(BASE_URL);
            }

            case "edge" -> {
                driver = getDriver("edge");
                driver.manage().window().maximize();
                driver.get(BASE_URL);
            }
        }
    }
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
