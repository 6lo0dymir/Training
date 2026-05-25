package threadqa_testing.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class StartPage extends BasePage {

    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()=\"Начать бесплатно\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id=\"login-email\"]")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@id=\"login-password\"]")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement enterButton;


}
