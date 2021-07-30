package com.selenium.zoopla.test;

import com.selenium.zoopla.base.BaseClass;
import com.selenium.zoopla.pages.AgentPage;
import com.selenium.zoopla.pages.Login;
import com.selenium.zoopla.pages.Properties;
import com.selenium.zoopla.utility.DashBoard;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZooplaTest extends BaseClass {

    @Test
    public void login_to_application_test() throws InterruptedException {

        Login login= new Login(driver);
        login.login_to_application();

    }
    @Test
    public void search_area_test() throws InterruptedException {

        Login login= new Login(driver);
        login.login_to_application();
        DashBoard dashBoard=new DashBoard(driver);
        dashBoard.search_text();
    }
    @Test
    public void view_properties_list_test() throws InterruptedException {
        Login login= new Login(driver);
        login.login_to_application();
        DashBoard dashBoard=new DashBoard(driver);
        dashBoard.search_text();
        Properties properties=new Properties(driver);
        properties.propertiesList();
        AgentPage agentsPage = new AgentPage(driver);

        boolean bool = agentsPage.check_all_properties_belong_to_agents();
        Assert.assertTrue(bool);
    }
}
