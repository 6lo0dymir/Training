package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.*;
import threadqa_testing.pages.*;
import threadqa_testing.utils.*;


@Owner("Владимир Терехин")
@Feature("Авторизация на сайте")

public class AutorisationTests extends BaseTest {
    private StartPage startPage;
    private ConfigReader credsreader;

    @BeforeClass
    void SetUp(){
        startPage = new StartPage(driver);
        credsreader = new ConfigReader("Creds");
    }
    @Test(description = "Позитивный тест с валидным логином и паролем")
    public void loginWithValidLoginAndPassword(){

        startPage.loginByEmail(
                credsreader.getLogin(),
                credsreader.getPassword()
        );
    }
}
