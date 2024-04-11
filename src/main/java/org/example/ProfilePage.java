package org.example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    private final SelenideElement textFieldAboutUser = $(By.xpath(".//textarea[@name='long_bio']"));

    private final SelenideElement saveAboutUser = $(By.xpath(".//div[@class='text-field_control __save']/button"));

    private final SelenideElement aboutUserTitle = $(By.xpath(".//div[@tsid='TextFieldText']"));

    public boolean checkAboutUser(CharSequence input){
        aboutUserTitle.click();

        textFieldAboutUser.shouldBe(visible).clear();

        textFieldAboutUser.sendKeys(input);

        String s = aboutUserTitle.getText();
        saveAboutUser.click();


        return s.equals(input.toString()) ;
//
//        saveAboutUser.click();
//        String s = aboutUserTitle.getText();
//        System.out.println(s);
//        return s.equals(input.toString());
    }


}
