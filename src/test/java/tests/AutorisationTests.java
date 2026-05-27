package tests;

import base.BaseTest;
import com.beust.ah.*;
import io.qameta.allure.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;
import threadqa_testing.pages.*;
import threadqa_testing.utils.*;


@Owner("Владимир Терехин")
@Feature("Авторизация на сайте")

public class AutorisationTests extends BaseTest {
    private StartPage startPage;
    private ConfigReader credsreader;

    @BeforeMethod
    void SetUp(){
        startPage = new StartPage(driver);

        credsreader = new ConfigReader("Creds");
    }


    @Test(description = "Позитивный тест с валидным логином и паролем")
    public void loginWithValidLoginAndPasswordWithJS() {

        startPage.loginByEmailWithJS(
                credsreader.getLogin(),
                credsreader.getPassword()
        );
        UserCabinetPage userCabinetPage = new UserCabinetPage(driver);
        try{
            Assert.assertEquals(userCabinetPage.getCurrentEmail(),credsreader.getLogin());
            Print.printMessage("Отображается верный Email");
        }catch (AssertionError e){
            Print.printMessage("Ошибка валидации: " + e.getMessage());
        }

    }
    @Test(description = "Негативный тест - невалидный логин, валидный пароль")
    public void loginWithInvalidLoginAndValidPassword(){

        startPage.loginByEmailWithJS(
                credsreader.getInvalidLogin(),
                credsreader.getPassword()
        );
        String expectedMessage = "Неверный email или пароль";
        try {
            Assert.assertEquals(startPage.getErrorMessageLoginPassword(), expectedMessage);
            Print.printMessage("Тест пройден: сообщение об ошибке совпадает");
        } catch (AssertionError e) {
            Print.printMessage("Ошибка валидации: " + e.getMessage());
        }
    }
    @Test(description = "Негативный тест - валидный логин, невалидный пароль")
    public void loginWithValidLoginAndInvalidPassword(){

        startPage.loginByEmailWithJS(
                credsreader.getLogin(),
                credsreader.getInvalidPassword()
        );
        String expectedMessage = "Неверный email или пароль";
        try {
            Assert.assertEquals(startPage.getErrorMessageLoginPassword(), expectedMessage);
            Print.printMessage("Тест пройден: сообщение об ошибке совпадает");
        } catch (AssertionError e) {
            Print.printMessage("Ошибка валидации: " + e.getMessage());
        }
    }
}
