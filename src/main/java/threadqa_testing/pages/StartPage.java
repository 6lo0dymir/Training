package threadqa_testing.pages;

import io.qameta.allure.*;
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

    @FindBy(xpath = "//button[@id=\"radix-_r_5a_\"]")
    private WebElement userPopUpMenuButton;

    @FindBy(xpath = "//span[text()=\"Выйти из аккаунта\"]")
    private WebElement exitFromAccountButton;

    @Step("Вход в приложение по email")
    public void loginByEmail(String email, String password) {
        clickElement(loginButton)
                .sendKeysToElement(inputLogin, email)
                .sendKeysToElement(inputPassword, password)
                .clickElement(enterButton);
    }

}
