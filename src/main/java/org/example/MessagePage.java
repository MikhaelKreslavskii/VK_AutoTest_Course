package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MessagePage {
    private final SelenideElement textField = $(By.xpath(".//msg-input[@data-tsid='write_msg_input']"));

    private  final SelenideElement sendButton = $(By.xpath(".//button[@data-tsid='button_send']"));

    private final SelenideElement sendMessage = $(By.xpath(".//msg-message[@sequence='last']/div/div/div/div/span/span"));

    private final SelenideElement firstMessageFromList = $(By.xpath(".//msg-chats-list-item[@tabindex='0']"));
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
