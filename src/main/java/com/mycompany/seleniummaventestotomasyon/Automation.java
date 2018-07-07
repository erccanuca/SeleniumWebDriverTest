/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seleniummaventestotomasyon;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Automation {
    
    private static WebDriver driver = null;
    
    private final static String URL = "https://www.n11.com/";

    public Automation() {
        
        //Set path for driver exe
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
        
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getURL() {
        return URL;
    }
    
    public static void setDriver(WebDriver driver) {
        Automation.driver = driver;
    }
    /**
     * Open browser method
    */
    public void OpenBrowser()
    {
        driver.get(URL);
        
        driver.manage().window().maximize(); // maximize page
    }
    
    /**
     * This is loaded home page alert!.
    */
    public void LoadedHomePage()
    {
        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('Loaded Home Page');");
       
        WaitTime(2000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }
   /**
    * Load Sign in page method
    */
    public void SwichLogingPageAndSignIn()
    {
        WaitTime(2000);
        driver.navigate().to("https://www.n11.com/giris-yap");
        
        driver.findElement(By.cssSelector("#email")).sendKeys("ercanuca@gmail.com");
        WaitTime(2000);
        driver.findElement(By.cssSelector("#password")).sendKeys("nacre123456");
        WaitTime(2000);
        driver.findElement(By.cssSelector("#loginButton")).click();
        
    }
    
    /**
     * Wait for 5 seconds method
     * @param miliseconds
     */
    public void WaitTime(long miliseconds)
    {
        long startTime = System.currentTimeMillis();
        
        long estimatedTime = System.currentTimeMillis() - startTime;
        try {
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(miliseconds);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainDemoClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Search 'samsung' page method
     */
    public void Search()
    {
        WaitTime(2000);
        
        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('Logged in account!');");
        
        WaitTime(2000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        
        driver.findElement(By.cssSelector("#searchData")).sendKeys("samsung");
        WaitTime(2000);
        driver.findElement(By.cssSelector("a.searchBtn")).click();             
        
        
        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('Loaded Search Page');");
        
        WaitTime(2000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

    }
    /**
     * Scroll down for click 2. page
     */
    public void scrollPageDown(){
        
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,6000)");
    }
    /**
     * Swap second searched page
     */
    public void Swap_2_page2()
    {
        WaitTime(2000);
        driver.findElement(By.xpath("//a[@href ='https://www.n11.com/arama?q=samsung&pg=2']")).click();
        WaitTime(2000);
        
        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('Loaded Search Page 2');");
        
        WaitTime(2000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        
        WaitTime(2000);
    }
    
    /**
     * Add favorite method
    */
    public void AddFavorite_3_product()
    {
        Actions actions = new Actions(driver);
        List<WebElement> elements = driver.findElements(By.cssSelector("span.textImg.followBtn"));
       
        WaitTime(2000);
        actions.moveToElement(elements.get(2)).click().build().perform();
       
     
        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('Added Favorite 3. product!');");
        
        WaitTime(2000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        WaitTime(2000);
        
        // up page 
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
    }
   /**
    * Click my favorite pages method 
    */
    public void Click_My_Favites()
    {
        driver.findElement(By.cssSelector("a.menuTitle")).click();  
        https://www.n11.com/hesabim
        WaitTime(5000);
        
        driver.findElement(By.linkText("İstek Listelerim")).click();
        
        WaitTime(3000);
        
        WebElement element = driver.findElement(By.cssSelector("h4.listItemTitle"));
        String number = "";
        boolean find = false;
        for(int i = 0;  i < element.getText().length(); ++i)
        {
            if(element.getText().charAt(i) == '(')
                find = true;
            else if(find && element.getText().charAt(i) != ')' )
                number += element.getText().charAt(i);
        }
        //System.out.println("--------------:"+number);
        String alert = "alert('";
        alert += "You have ";
        alert += number;
        alert += " favorite products.";
        alert += "');";
      
        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript(alert);
        
        WaitTime(2000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        WaitTime(2000);
        
        
    }
    /**
     * Remove Favorite product
     */
    public void Remove_favorite()
    {
        
        driver.findElement(By.cssSelector("h4.listItemTitle")).click();
        
        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('Loaded Favorite Page');");
        
        WaitTime(2000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        
        WaitTime(3000);
        
        driver.findElement(By.cssSelector("span.deleteProFromFavorites")).click();
        WaitTime(4000);
        
        driver.findElement(By.cssSelector("span.btn.btnBlack.confirm")).click();
        
        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('Removed favorite product.');");
        
        WaitTime(3000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        
        WaitTime(3000);  
        
    }  
    /**
     * Exit to browser
     */
    public void exit() 
    {
        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('Thanks - Good By!');");
        
        WaitTime(2000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        
        WaitTime(3000);
        
        
        driver.close();
        driver.quit();
    }
}
