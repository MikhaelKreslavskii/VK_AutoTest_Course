package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private final SelenideElement profileName = $(By.xpath(".//*[@id='hook_Block_Navigation']/div/div/div[1]/a"));

    private final SelenideElement searchTextField = $(By.xpath(".//*[@placeholder='Искать на сайте']"));

    private final SelenideElement popupSearch = $(By.xpath(".//*[@id='hook_Block_AdditionalColumn']"));

    private final SelenideElement message = $(By.xpath(".//*[@class='toolbar_nav_a toolbar_nav_a__messa js-msg-tt h-mod __a11y']"));

    private final SelenideElement buttonToProfile = $(By.xpath("//*[@id='hook_Block_Navigation']/div/div/div[1]/a"));

    private final SelenideElement post = $(By.xpath(".//[@data-feed-id='0801000000896307649e0001b57400000001001853d5063afba800006b9f0c629e6e']"));

    private final SelenideElement countOfLikes = $(By.xpath("//*[@id='hook_Block_3267957266']/div/a/span"));

    private final SelenideElement likeButton = $(By.xpath("/html/body/div[11]/div[5]/div[4]/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div/div[3]/main/div/div[2]/div[3]/div/div[3]/div[1]/div[1]/div[5]/div/div[2]/div[4]/ul/li[3]/div[1]/div/span"));

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

    public boolean likePost()
    {
        String currentCountOfLikes = countOfLikes.shouldBe(visible).getText();
        System.out.println(currentCountOfLikes);
        String currentLikes = currentCountOfLikes.split("\\s+")[0];
        int curLikesInt = Integer.parseInt(currentLikes);
        System.out.println(currentLikes);
        likeButton.click();
        refresh();
        String newCountOfLikes = countOfLikes.getText();
        int newLikes = Integer.parseInt(newCountOfLikes.split("\\s+")[0]);

        System.out.println(newLikes);

        return newLikes - curLikesInt == 1;

    }

    public void disLikePost()
    {
        likeButton.click();
    }

}
