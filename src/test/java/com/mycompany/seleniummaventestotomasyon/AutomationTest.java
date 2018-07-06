/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seleniummaventestotomasyon;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author ercan
 */
public class AutomationTest {
    
    private static WebDriver driver = null;
    private final static String URL = "https://www.n11.com/";
   
    public AutomationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.n11.com/");
        driver.manage().window().maximize(); // maximize page
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of OpenBrowser method, of class Automation.
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testOpenBrowser() throws InterruptedException {
        
        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());

        //assertEquals method Parameters: Message, Expected Value, Actual Value
        Assert.assertEquals("Title check failed!", "n11.com - Alışverişin Uğurlu Adresi", driver.getTitle());
 
        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
       
    }

    /**
     * Test of LoadedHomePage method, of class Automation.
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testLoadedHomePage() throws InterruptedException {
        
        
        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
       
        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('Loaded Home Page');");
       
        Alert alert = driver.switchTo().alert();
        
        Assert.assertTrue(alert.getText().contains("Loaded Home Page"));
        Thread.sleep(2000);
        alert.accept();
        driver.switchTo().defaultContent();
        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
       
        
    }

    /**
     * Test of SwichLogingPageAndSignIn method, of class Automation.
     */
    @Test
    public void testSwichLogingPageAndSignIn() {
        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
        
        
        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());

        
        
    }

    /**
     * Test of WaitTime method, of class Automation.
     */
    @Test
    public void testWaitTime() {
        System.out.println("WaitTime");
        
    }

    /**
     * Test of Search method, of class Automation.
     */
    @Test
    public void testSearch() {
        System.out.println("Search");
       
    }

    /**
     * Test of scrollPageDown method, of class Automation.
     */
    @Test
    public void testScrollPageDown() {
        System.out.println("scrollPageDown");
        
    }

    /**
     * Test of Swap_2_page2 method, of class Automation.
     */
    @Test
    public void testSwap_2_page2() {
        System.out.println("Swap_2_page2");
      
    }

    /**
     * Test of AddFavorite_3_product method, of class Automation.
     */
    @Test
    public void testAddFavorite_3_product() {
        System.out.println("AddFavorite_3_product");
       
    }

    /**
     * Test of Click_My_Favites method, of class Automation.
     */
    @Test
    public void testClick_My_Favites() {
        System.out.println("Click_My_Favites");
        
    }

    /**
     * Test of Remove_favorite method, of class Automation.
     */
    @Test
    public void testRemove_favorite() {
        System.out.println("Remove_favorite");
       
    }

    /**
     * Test of exit method, of class Automation.
     */
    @Test
    public void testExit() {
        System.out.println("exit");
        
    }
    
}
