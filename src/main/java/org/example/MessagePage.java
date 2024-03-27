package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MessagePage {
    private final SelenideElement textField = $(By.xpath("/html/body/div[22]/div[2]/div[1]/div[2]/msg-app/div/msg-page/div[2]/msg-chat/div/section/footer/msg-posting-form/div/form/msg-message-editor/div/div/msg-input/div[2]"));

    private  final SelenideElement sendButton = $(By.xpath("/html/body/div[22]/div[2]/div[1]/div[2]/msg-app/div/msg-page/div[2]/msg-chat/div/section/footer/msg-posting-form/div/form/msg-message-editor/div/aside[2]/slot/div/button[3]"));

    private final SelenideElement sendMessage = $(By.xpath("/html/body/div[22]/div[2]/div[1]/div[2]/msg-app/div/msg-page/div[2]/msg-chat/div/section/div/msg-message-list/div/div[4]/msg-message[2]/div[1]/div/div/div/span/span"));

    private final SelenideElement firstMessageFromList = $$(By.xpath("/html/body/div[22]/div[2]/div[1]/div[2]/msg-app/div/msg-page/div[1]/msg-chats-panel/div/msg-chats-list/msg-chats-list-item/a")).first();
    public boolean typeInTextField(CharSequence input)
    {

        firstMessageFromList.click();
        textField.sendKeys(input);
        sendButton.click();
        String s =  sendMessage.getText();

        if (s.equals(input.toString()))
        {
            return true;
        }


        return false;


    }

}
