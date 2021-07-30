package com.selenium.zoopla.utility;

import com.selenium.zoopla.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard extends BaseClass {

    @FindBy(xpath = "//a[normalize-space()='To rent']")
    WebElement rent_btn;

    @FindBy(id = "search-input-location")
    WebElement searchWord;


    public DashBoard(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void search_text() throws InterruptedException {
        rent_btn.click();
        Thread.sleep(3000);
        searchWord.sendKeys("London");
        searchWord.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
//        Thread.sleep(2000);
    }
}
