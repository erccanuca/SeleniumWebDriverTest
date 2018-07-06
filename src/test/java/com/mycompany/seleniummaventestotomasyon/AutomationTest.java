/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seleniummaventestotomasyon;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testSwichLogingPageAndSignIn() throws InterruptedException {
        
        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
        // load log in page
        Thread.sleep(2000);
        driver.navigate().to("https://www.n11.com/giris-yap");
        // test 
        Assert.assertEquals("Title check failed!", "Giriş Yap - n11.com", driver.getTitle());

        // entered email
        WebElement elementEmail = driver.findElement(By.cssSelector("#email"));
        elementEmail.sendKeys("ercanuca@gmail.com");
        Thread.sleep(2000);
        // test
        Assert.assertEquals("Email check failed!", "ercanuca@gmail.com", elementEmail.getAttribute("value"));
        
        // entered pws
        WebElement elementPsw = driver.findElement(By.cssSelector("#password"));
        elementPsw.sendKeys("nacre123456");
        Thread.sleep(2000);
        // test
        Assert.assertEquals("Password check failed!", "nacre123456", elementPsw.getAttribute("value"));

        // click log in
        WebElement elementLogin = driver.findElement(By.cssSelector("#loginButton"));
        Assert.assertEquals("Log in check failed!", "Üye Girişi", elementLogin.getText());
        elementLogin.click();
        
        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
   
    }

    /**
     * Test of WaitTime method, of class Automation.
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testWaitTime() throws InterruptedException {
        
        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
        long miliseconds = 1000L;
        
        long startTime = System.currentTimeMillis();
        
        // wait explict time
        Thread.sleep(miliseconds);
        
        long estimatedTime = System.currentTimeMillis() - startTime;
        if(estimatedTime >= 1000 && estimatedTime <= 1020)
            estimatedTime = miliseconds;
        
        // test wait time & elapsed time
        Assert.assertEquals(estimatedTime, miliseconds);
        
        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
    } 

    /**
     * Test of Search method, of class Automation.
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testSearch() throws InterruptedException {

        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
        Thread.sleep(2000);
        
        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('Logged in account!');");
        
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        
        Assert.assertTrue(alert.getText().contains("Logged in account!"));
        alert.accept();
        driver.switchTo().defaultContent();
        
        WebElement searchEle = driver.findElement(By.cssSelector("#searchData"));
        searchEle.sendKeys("samsung");
        // test
        Assert.assertEquals("Search samsung check failed!", "samsung", searchEle.getAttribute("value"));
        
        Thread.sleep(2000);
        // click Search
        WebElement elementSearchBtn = driver.findElement(By.cssSelector("a.searchBtn"));
        //System.out.println("tagname : " + elementSearchBtn.getTagName());
        Assert.assertEquals("Log in check failed!", "a", elementSearchBtn.getTagName());
        elementSearchBtn.click();       

        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('Loaded Search Page');");
        
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        
        System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());

       
    }

    /**
     * Test of scrollPageDown method, of class Automation.
     */
    @Test
    public void testScrollPageDown() {
        
        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
        System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
    }

    /**
     * Test of Swap_2_page2 method, of class Automation.
     */
    @Test
    public void testSwap_2_page2() {

        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
        System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
    }

    /**
     * Test of AddFavorite_3_product method, of class Automation.
     */
    @Test
    public void testAddFavorite_3_product() {

        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
        System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }

    /**
     * Test of Click_My_Favites method, of class Automation.
     */
    @Test
    public void testClick_My_Favites() {

        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName()); 
        
        
        System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
            
    }

    /**
     * Test of Remove_favorite method, of class Automation.
     */
    @Test
    public void testRemove_favorite() {

        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
        
        System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }

    /**
     * Test of exit method, of class Automation.
     */
    @Test
    public void testExit() {
        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
        System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }
    
}
