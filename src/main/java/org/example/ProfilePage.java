package org.example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    private final SelenideElement textFieldAboutUser = $(By.xpath("/html/body/div[11]/div[5]/div[4]/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[1]/div[3]/div/div[2]/div[1]/div/div[2]/div/div[1]/textarea"));

    private final SelenideElement saveAboutUser = $(By.xpath("/html/body/div[11]/div[5]/div[4]/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[1]/div[3]/div/div[2]/div[1]/div/div[2]/div/div[4]/div[1]/button"));

    private final SelenideElement aboutUserTitle = $(By.xpath("/html/body/div[11]/div[5]/div[4]/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[1]/div[3]/div/div[2]/div[1]/div/div[2]/div/div[1]/div[2]"));

    public boolean checkAboutUser(CharSequence input){
        aboutUserTitle.shouldBe(visible).doubleClick();
        textFieldAboutUser.clear();
        textFieldAboutUser.sendKeys(input);
        String s = aboutUserTitle.getText();
        System.out.println( aboutUserTitle.getText());

        saveAboutUser.click();


        return s.equals(input.toString()) ;
//
//        saveAboutUser.click();
//        String s = aboutUserTitle.getText();
//        System.out.println(s);
//        return s.equals(input.toString());
    }


}
