package com.selenium.zoopla.pages;

import com.selenium.zoopla.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseClass {

    public static String username="diliprathodtest@gmail.com";
    public static String password="Login@123";

    @FindBy(xpath = "//input[@id='input-email-address']")
    WebElement input_email;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div/div/header/div/div/div[1]/div[2]/ul/li[5]/a")
    WebElement sign_in_btn;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement input_pwd;

    @FindBy(xpath = "//button[normalize-space()='Sign in']")
    WebElement sign_in;

    public Login(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String login_to_application() throws InterruptedException {
        sign_in_btn.click();
        Thread.sleep(1000);
        input_email.sendKeys(username);
        Thread.sleep(2000);
        input_pwd.sendKeys(password);
        Thread.sleep(2000);
        sign_in.click();
        Thread.sleep(3000);
        return driver.getCurrentUrl();
    }
}
