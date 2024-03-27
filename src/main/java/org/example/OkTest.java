package org.example;

import com.codeborne.selenide.SelenideElement;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OkTest extends BaseTest{

    private final static String LOGIN_URL = "https://ok.ru/";



    public void passAuth()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.openWebSite(LOGIN_URL);
        loginPage.logInCheck();
    }

    /**
     * Тест на проверку корректности логина и перехода на страницу с соответствующим profileName
     */
    @Test
    public void checkLogin()
    {
        passAuth();
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        String profileName = homePage.getProfileName();

        Assertions.assertTrue(profileName.contains(loginPage.getLogin()));
    }

    /**
     * Проверка на открытие попап окна при клике на поисковую строку
     */
    @Test
    public void checkSearchTextField()
    {
        passAuth();
        HomePage homePage = new HomePage();
       boolean resultPopUp =  homePage.clickSearchTextField();
        Assertions.assertTrue(resultPopUp);


    }

    /**
     * Проверка на отправку сообщения и корректное отображение в чате
     */
    @Test
    public void checkSendMessage(){
        passAuth();
        HomePage homePage = new HomePage();
        homePage.goToChat();
        MessagePage messagePage = new MessagePage();
        Assertions.assertTrue(messagePage.typeInTextField("Hello"));
    }

    /**
     * Проверка изменения статуса в профиле "О себе"
     */
    @Test
    public void checkAboutUser()
    {
        passAuth();
        HomePage homePage = new HomePage();
        homePage.goToProfile();
        ProfilePage profilePage = new ProfilePage();
        Assertions.assertTrue(profilePage.checkAboutUser("Love football"));


    }

}
