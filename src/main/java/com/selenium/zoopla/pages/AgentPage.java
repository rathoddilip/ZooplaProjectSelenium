package com.selenium.zoopla.pages;

import com.selenium.zoopla.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AgentPage extends BaseClass {

    @FindBy(xpath = "//div[@class='clearfix']/div[1]/h1/a")
    WebElement agentName;
    @FindBy(xpath = "//p[@class='top-half listing-results-marketed']/span")
    List<WebElement> propertiesAgentsName;

    public AgentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean check_all_properties_belong_to_agents() {
        boolean flag = true;
        for (WebElement agent: propertiesAgentsName) {
            String[] agent_name = agent.getText().split(",") ;
            System.out.println(agent_name[0]);
            if (!agent_name[0].equals(agentName.getText())) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
