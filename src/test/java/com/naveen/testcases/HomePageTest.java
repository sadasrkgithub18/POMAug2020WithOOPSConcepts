package com.naveen.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.naveen.supporters.ExcelReader;
import com.naveen.tests.BaseEngine;
import com.naveen.util.FilePaths;
import com.naveen.webpages.HomePage;
import com.naveen.webpages.LoginPage;

public class HomePageTest extends BaseEngine
{
   public ExcelReader excelReader;
   
   @Test(priority =1)
   public void verfiyHomePageTitle()
   {
	   try 
		{
		  excelReader = new ExcelReader(FilePaths.excelPath);
		} 
		catch (EncryptedDocumentException | InvalidFormatException | IOException e) 
		{
		    e.printStackTrace();
		}
	 	
	   getpage().getInstance(LoginPage.class).doLogin(excelReader.getSingleCellData("TestingData",0,0), excelReader.getSingleCellData("TestingData",0,1));
	   String titleHP =  getpage().getInstance(HomePage.class).getHomePageTitle();
	  
	   System.out.println("Title of home page is: "+titleHP);
	   Assert.assertEquals(titleHP, "actiTIME - Open Tasks");
	   
	   getpage().getInstance(HomePage.class).clickOnLogout();
   }
   
   @Test(priority = 2)
   public void verifyHomePageHeader()
   {
		
		  try 
		  { 
			excelReader = new ExcelReader(FilePaths.excelPath); 
		  }
		  catch(EncryptedDocumentException | InvalidFormatException | IOException e) 
		  {
		    e.printStackTrace(); 
		  }
		 
	   getpage().getInstance(LoginPage.class).doLogin(excelReader.getSingleCellData("TestingData",0,0), excelReader.getSingleCellData("TestingData",0,1));
	   boolean titleHP =  getpage().getInstance(HomePage.class).getHomePageHeader();
	  
	   System.out.println("Header of home page is displayed or not: "+titleHP);
	   Assert.assertEquals(titleHP, true);
	   
	   getpage().getInstance(HomePage.class).clickOnLogout();
   }
}
