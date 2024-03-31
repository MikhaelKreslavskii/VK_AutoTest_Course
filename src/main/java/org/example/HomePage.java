package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private final SelenideElement profileName = $(By.xpath("/html/body/div[11]/div[5]/div[4]/div[1]/div/div[2]/div[2]/div[3]/div[2]/aside/nav/div/div[4]/div/div/div/div[1]/a/div"));

    private final SelenideElement searchTextField = $(By.xpath("/html/body/div[11]/div[4]/div/div[1]/div/div[5]/toolbar-search/form/div/label/input"));

    private final SelenideElement popupSearch = $(By.xpath("/html/body/div[11]/div[4]/div/div[1]/div/div[5]/toolbar-search/form/div/div[3]"));

    private final SelenideElement message = $(By.xpath("/html/body/div[11]/div[4]/div/div[1]/div/nav/ul/li[1]/button/span[1]"));

    private final SelenideElement buttonToProfile = $(By.xpath("/html/body/div[11]/div[5]/div[4]/div[1]/div/div[2]/div[2]/div[3]/div[2]/aside/nav/div/div[4]/div/div/div/div[1]/a/div"));

    private final SelenideElement post = $(By.xpath(".//[@data-feed-id='0801000000896307649e0001b57400000001001853d5063afba800006b9f0c629e6e']"));

    private final SelenideElement countOfLikes = $(By.xpath("/html/body/div[11]/div[5]/div[4]/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div/div[3]/main/div/div[2]/div[3]/div/div[3]/div[1]/div[1]/div[5]/div/div[2]/div[4]/div/div[1]/div/a/span"));

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
        String currentCountOfLikes = countOfLikes.getText();
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
