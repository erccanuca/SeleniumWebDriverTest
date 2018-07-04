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
    private final static String URL = "https://www.n11.com/";
    
    
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
        Search();
        scrollPageDown();
        
        // Swap 2. search page
        Swap_2_page2();
        
        
        // added 3. product to favorite
        AddFavorite_3_product();
        
        
        // click my favorites
       // Click_My_Favites();
        
    }
    
    /**
     * Open browser method
    */
    public static void OpenBrowser()
    {
        //Set path for driver exe
        System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\ercan\\Documents\\NetBeansProjects\\SeleniumMavenTestOtomasyon\\src\\main\\java\\com\\mycompany\\seleniummaventestotomasyon\\chromedriver.exe");
        
        driver = new ChromeDriver();

        driver.get(URL);
        
        driver.manage().window().maximize(); // maximize page
    }
    
    /**
     * This is loaded home page alert!.
     * @throws InterruptedException if interrupt the running project throw it.
    */
    public static void LoadedHomePage() throws InterruptedException
    {
        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('Loaded Home Page');");
       
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
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
    /**
     * Search 'samsung' page method
     * @throws java.lang.InterruptedException
     */
    public static void Search() throws InterruptedException
    {
        
        driver.findElement(By.cssSelector("#searchData")).sendKeys("samsung");
        Wait_5_seconds();
        driver.findElement(By.cssSelector("a.searchBtn")).click();             
        ;
        
        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('Loaded Search Page');");
        
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

    }
    /**
     * Scroll down for click 2. page
     */
    public static void scrollPageDown(){
        
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,6000)");
    }
    /**
     * Swap second searched page
     * @throws java.lang.InterruptedException
     */
    public static void Swap_2_page2() throws InterruptedException
    {
        Wait_5_seconds();
        driver.findElement(By.xpath("//a[@href ='https://www.n11.com/arama?q=samsung&pg=2']")).click();
        Wait_5_seconds();
        
        //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('Loaded Search Page 2');");
        
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,3000)");
        Wait_5_seconds();
        Wait_5_seconds();
    }
    
    /**
     * Add favorite method
    */
    public static void AddFavorite_3_product()
    {
        driver.findElement(By.xpath("//*[@id=\"view\"]/ul/li[3]")).click();
        Wait_5_seconds();
        Wait_5_seconds();
        // up page //*[@id="view"]/ul/li[3]
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
    }
   
    public static void Click_My_Favites() throws InterruptedException
    {
        driver.findElement(By.cssSelector("a.menuTitle")).click();  
        
        Wait_5_seconds();
        Wait_5_seconds();
        
        driver.findElement(By.linkText("İstek Listelerim")).click();
         //Generating Alert Using Javascript Executor
        if (driver instanceof JavascriptExecutor)  
            ((JavascriptExecutor) driver).executeScript("alert('You have one favorite product');");
        
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        Wait_5_seconds();
        
        driver.findElement(By.cssSelector("ul.listItemProductList"));
        
    }
  
    
}
