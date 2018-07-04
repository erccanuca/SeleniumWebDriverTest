/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seleniummaventestotomasyon;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author ercan
 */
public class MainDemoClass {
    
    private static WebDriver driver = null;
    /**
     * Main Demo class 
     * @param args comment line arguments.
     */
    public static void main(String[] args) throws InterruptedException
    {
        // Open browser
        OpenBrowser();
        
        // Pop-up alert and loaded home page
        LoadedHomePage();
        Wait_5_seconds();
        
        // Swich to loging and Sign in to site.
        SwichLogingPageAndSignIn();
        Wait_5_seconds();
        
        // Search
    }
    
    /**
     * Open browser method
    */
    public static void OpenBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        
        driver.navigate().to("https://www.n11.com/");
        driver.manage().window().maximize();
    }
    
    /**
     * This is loaded home page alert!.
     * @throws InterruptedException if interrupt the running project throw it.
    */
    public static void LoadedHomePage() throws InterruptedException
    {
         //Generating Alert Using Javascript Executor
        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        javascript.executeScript("alert('Loaded Home page and cross to login!');");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
    }
   /**
    * Load Sign in page method
    */
    public static void SwichLogingPageAndSignIn()
    {
        driver.navigate().to("https://www.n11.com/giris-yap");
        
         driver.findElement(By.cssSelector("#email")).sendKeys("ercanuca@gmail.com");
        Wait_5_seconds();
        driver.findElement(By.cssSelector("#password")).sendKeys("nacre123456");
        Wait_5_seconds();
        driver.findElement(By.cssSelector("#loginButton")).click();
    }
    
    /**
     * Wait for 5 seconds method
     */
    public static void Wait_5_seconds()
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
