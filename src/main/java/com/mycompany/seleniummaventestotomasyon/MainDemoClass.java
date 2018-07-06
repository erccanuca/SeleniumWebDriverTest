/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seleniummaventestotomasyon;

/**
 *
 * @author ercan
 */
public class MainDemoClass {
    
    /**
     * Main Demo class 
     * @param args comment line arguments.
     */
    public static void main(String[] args)
    {
        
        Automation auto = new Automation();
        // Open browser
        auto.OpenBrowser();
        
        // Pop-up alert and loaded home page
        auto.LoadedHomePage();
        auto.WaitTime(5000);
        
        // Swich to loging and Sign in to site.
        auto.SwichLogingPageAndSignIn();
        auto.WaitTime(5000);
        
        // Search
        auto.Search();
        auto.scrollPageDown();
        
        // Swap 2. search page
        auto.Swap_2_page2();
        
        
        // added 3. product to favorite
        auto.AddFavorite_3_product();
        
        
        // click my favorites
        auto.Click_My_Favites();
        
        // remove favorite product
        auto.Remove_favorite();
        
        // close browser & quit
        auto.exit();  
    }   
}