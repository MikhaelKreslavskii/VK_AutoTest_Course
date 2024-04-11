package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private final SelenideElement submitButton = $(By.xpath(".//*[@value='Войти в Одноклассники']"));
    private final SelenideElement loginTextField = $(By.xpath(".//*[@name='st.email']"));

    private final SelenideElement passwordTextField = $(By.xpath(".//*[@name='st.password']"));

    private final String login = "technopol58";

    private final String password = "technopolisPassword";
    /**
     * Проверка страницы авторизации при валидных данных
     */
    public void logInCheck()
    {
        loginTextField.setValue(login);
        passwordTextField.setValue(password);
        submitButton.click();
    }


    public String getLogin()
    {
        return login;
    }

    public void openWebSite(String url){

        Selenide.open(url);


    }



}
