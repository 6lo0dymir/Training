package threadqa_testing.pages;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import threadqa_testing.utils.*;

public class UserCabinetPage extends BasePage {

    public UserCabinetPage(WebDriver driver) {super(driver);}

    @FindBy(xpath = "//h1[text()=\"Привет,\"]")
    private WebElement helloMessage;

    @FindBy(xpath = "//p[contains(text(), \"Студент\")]")
    private WebElement popUpUserMenu;

    @FindBy(xpath = "//div[@dir=\"ltr\"]//p[2]")
    private WebElement emailStringElement;

    @Step("Получение почты из выпадающего меню в ЛК")
    public String getCurrentEmail(){
        //BasePage.wait.until(ExpectedConditions.visibilityOf(helloMessage));
        clickElement(popUpUserMenu);
        return getTextFromElement(emailStringElement);
    }
    public void printHelloMessage(){
        Print.printMessage(helloMessage.getText());
    }
}
