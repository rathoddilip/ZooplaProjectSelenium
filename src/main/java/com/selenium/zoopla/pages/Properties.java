package com.selenium.zoopla.pages;

import com.selenium.zoopla.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Properties extends BaseClass {

    @FindBy(xpath = "//a[@data-testid = 'listing-details-link']")
    List<WebElement> propertiesList;
    @FindBy(xpath = "//div[@class='css-1e28vvi-PriceContainer e2uk8e7']")
    List<WebElement> properties_Prices;
    @FindBy(xpath = "//div[@class='css-1niyh5b-AgentHeader e11937k17']/a")
    WebElement agentLink;
    @FindBy(xpath = "//div[@class='css-8iph5w-AgentCallCTA e11937k10']/a")
    WebElement  agentNumber;
    @FindBy(xpath = "//p[@class='css-ur21rx-Text-AgentName e11937k16']")
    WebElement agentsName;

    public Properties(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void propertiesList() throws InterruptedException {
        List<Integer> pricesList = new ArrayList<>();
        properties_Prices.parallelStream().forEach(prices-> {
            String price = prices.getText().replaceAll("[^(0-9)]+", "");
            pricesList.add(Integer.valueOf(price));
        });
        pricesList.sort(Collections.reverseOrder(Comparator.comparingInt(Integer::intValue)));
        pricesList.forEach(System.out::println);
        Thread.sleep(2000);
        propertiesList.get(4).click();
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        System.out.println(agentNumber.getText());
        System.out.println(agentsName.getText());
        agentLink.click();
    }
}
