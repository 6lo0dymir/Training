package threadqa_testing.pages;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/** Базовая страница */
public class BasePage {

    protected static WebDriver driver;

    public static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    /** Найти титульный текст*/
    @FindBy (xpath = "//a[@aria-label=\"ThreadQA — главная\"]")
    private WebElement title;

    /** Клик по элементу с использованием JS */
    @Step("JS клик по элементу")
    protected void clickWithJS(WebElement webElement){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",webElement);
    }

    @Step("Клик по элементу")
    public BasePage clickElement(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
        return this;
    }
    /** При перехвате клика по элементу обычным способом, совершаем клик через JS */
    @Step("Клик по элементу с JS")
    public void clickElementWithJS(WebElement webElement) {
        try {
            webElement.click();
        } catch (ElementClickInterceptedException e) {
            clickWithJS(webElement);
        }
    }


    @Step("Пролистать страницу до элемента и кликнуть по нему")
    public void waitMoveAndClickElement(WebElement webElement) {
        wait.until(visibilityOf(webElement));
        wait.until(elementToBeClickable(webElement));
        new Actions(driver).moveToElement(webElement)
                .click()
                .perform();
    }

    @Step("Ввод в input-элемент")
    public BasePage sendKeysToElement(WebElement webElement, String text) {
        webElement.sendKeys(text);
        return this;
    }

    @Step("Получить текст из элемента")
    public String getTextFromElement(WebElement webElement){
        return webElement.getText();
    }
}
