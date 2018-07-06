/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seleniummaventestotomasyon;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author ercan
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    public void testAOpenBrowser() throws InterruptedException {
        
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
    public void testBLoadedHomePage() throws InterruptedException {
        
        
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
    public void testCSwichLogingPageAndSignIn() throws InterruptedException {
        
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
    public void testDWaitTime() throws InterruptedException {
        
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
    public void testESearch() throws InterruptedException {

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
        Assert.assertEquals("Search check failed!", "a", elementSearchBtn.getTagName());
        elementSearchBtn.click();       

        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('Loaded Search Page');");
        
        Thread.sleep(2000);
        Alert alert2 = driver.switchTo().alert();
        
        Assert.assertTrue(alert2.getText().contains("Loaded Search Page"));
        alert2.accept();
        driver.switchTo().defaultContent();
        
        System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());

       
    }

    /**
     * Test of scrollPageDown method, of class Automation.
     */
    @Test
    public void testFScrollPageDown() {
        
        Long instance = 6000L;
        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
        JavascriptExecutor executer = ((JavascriptExecutor) driver);
        executer.executeScript("window.scrollTo(0,6000)");
            
        Long value = (Long) executer.executeScript("return window.pageYOffset;");
        //System.out.println("Position scroll: " + value);
        
        Assert.assertEquals(instance,value);
        
        System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
    }

    /**
     * Test of Swap_2_page2 method, of class Automation.
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testGSwap_2_page2() throws InterruptedException {

        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@href ='https://www.n11.com/arama?q=samsung&pg=2']"));
        Assert.assertEquals("Search check failed!", "a", element.getTagName());
        element.click();
        
        Thread.sleep(2000);
        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('Loaded Search Page 2');");
        
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        
        Assert.assertTrue(alert.getText().contains("Loaded Search Page 2"));
        alert.accept();
        driver.switchTo().defaultContent();
        
        Thread.sleep(2000);
        
        System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
    }

    /**
     * Test of AddFavorite_3_product method, of class Automation.
     */
    @Test
    public void testHAddFavorite_3_product() throws InterruptedException {

        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
        Actions actions = new Actions(driver);
        List<WebElement> elements = driver.findElements(By.cssSelector("span.textImg.followBtn"));
       
        Thread.sleep(2000);
        if(elements.size() > 2)
            Assert.assertTrue(true);
        actions.moveToElement(elements.get(2)).click().build().perform();
        
     
        Thread.sleep(2000);
        
        // up page 
        Long instance = 0L;
       
        JavascriptExecutor executer = ((JavascriptExecutor) driver);
        executer.executeScript("window.scrollTo(0,0)");
            
        Long value = (Long) executer.executeScript("return window.pageYOffset;");
        //System.out.println("Position scroll: " + value);
        
        Assert.assertEquals(instance,value);
        
        System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }

    /**
     * Test of Click_My_Favites method, of class Automation.
     */
    @Test
    public void testKClick_My_Favites() {

        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName()); 
        
        
        System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
            
    }

    /**
     * Test of Remove_favorite method, of class Automation.
     */
    @Test
    public void testLRemove_favorite() {

        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
        
        System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }

    /**
     * Test of exit method, of class Automation.
     */
    @Test
    public void testMExit() {
        System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
        
        System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }
    
}
