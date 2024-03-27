package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {

    private final SelenideElement profileName = $(By.xpath("/html/body/div[11]/div[5]/div[4]/div[1]/div/div[2]/div[2]/div[3]/div[2]/aside/nav/div/div[4]/div/div/div/div[1]/a/div"));

    private final SelenideElement searchTextField = $(By.xpath("/html/body/div[11]/div[4]/div/div[1]/div/div[5]/toolbar-search/form/div/label/input"));

    private final SelenideElement popupSearch = $(By.xpath("/html/body/div[11]/div[4]/div/div[1]/div/div[5]/toolbar-search/form/div/div[3]"));

    private final SelenideElement message = $(By.xpath("/html/body/div[11]/div[4]/div/div[1]/div/nav/ul/li[1]/button/span[1]"));

    private final SelenideElement buttonToProfile = $(By.xpath("/html/body/div[11]/div[5]/div[4]/div[1]/div/div[2]/div[2]/div[3]/div[2]/aside/nav/div/div[4]/div/div/div/div[1]/a/div"));

    public String getProfileName()
    {
        System.out.println(profileName.getText());
        return profileName.getText();
    }

    public boolean clickSearchTextField()
    {
        searchTextField.click();
       boolean exist = popupSearch.shouldBe(visible).exists();
        System.out.println(exist);
       return exist;

    }

    public void goToChat(){

        message.click();
    }

    public void goToProfile()
    {
        buttonToProfile.click();
    }

}
