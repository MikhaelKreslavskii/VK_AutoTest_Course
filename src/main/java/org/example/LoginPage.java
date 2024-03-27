package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private final SelenideElement submitButton = $(By.xpath("/html/body/div[11]/div[5]/div[2]/div[1]/div/div/div/div[2]/div[3]/div[3]/div/div/main/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/form/div[4]/input"));
    private final SelenideElement loginTextField = $(By.xpath("/html/body/div[11]/div[5]/div[2]/div[1]/div/div/div/div[2]/div[3]/div[3]/div/div/main/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/form/div[1]/div/input"));

    private final SelenideElement passwordTextField = $(By.xpath("/html/body/div[11]/div[5]/div[2]/div[1]/div/div/div/div[2]/div[3]/div[3]/div/div/main/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/form/div[2]/div/input"));

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
