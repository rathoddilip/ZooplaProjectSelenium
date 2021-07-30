package com.selenium.zoopla.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    public static WebDriver driver;

    @BeforeTest

    public void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.zoopla.co.uk/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
}
