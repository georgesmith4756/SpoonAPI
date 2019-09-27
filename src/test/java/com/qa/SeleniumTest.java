package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private ChromeDriver driver;
    private JavascriptExecutor js;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\georg\\IdeaProjects\\SpoonsMapAPI\\src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();

        js = (JavascriptExecutor) driver;


    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void clickAddButton() throws InterruptedException{

        WebElement button = driver.findElementById("pub-add-button");
        button.click();
        Thread.sleep(2000);

    }

    @Test
    public void mainTest() throws InterruptedException {
        driver.manage().window().maximize();//max screen
        driver.get("http://http://34.90.35.87/");
        Thread.sleep(3000);

        clickAddButton();



        //searchField.sendKeys("funny cat pictures");

        //WebElement submitButton = driver.findElement(By.name("btnK"));
        //submitButton.click();

        //WebElement linkToBiggerPictures = driver.findElementByLinkText("Images for funny cat");//partial link test too is an option
        //linkToBiggerPictures.click();

        // int counter = 1;
        // for(int i = 0; i < 100; i++)
        // {
        //     js.executeScript("window.scrollBy(" + i + "," + (counter++) +")"); //Scroll vertically down by 1000 pixels
        //     Thread.sleep(50);
        // }

    }


}
