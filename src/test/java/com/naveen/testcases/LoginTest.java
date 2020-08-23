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


public class LoginTest extends BaseEngine
{
    public ExcelReader excelReader;
	
    @Test(priority = 1)
	public void verifyLoginPageTitleTest()
	{
		String titleA = getpage().getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println("Login Page title is: "+titleA);
		Assert.assertEquals(titleA, "actiTIME - Login");
	}
	
	@Test(priority = 2)
	public void verifyLoginPageHeaderTest()
	{
		boolean title = getpage().getInstance(LoginPage.class).getPageHeader();
		System.out.println("Login Page Header is: "+title);
		Assert.assertEquals(title, true);
	}
	
	@Test(priority = 3)
	public void doLoginTest()
	{
		try 
		{
		  excelReader = new ExcelReader(FilePaths.excelPath);
		} 
		catch (EncryptedDocumentException | InvalidFormatException | IOException e) 
		{
		    e.printStackTrace();
		}
		   
		HomePage homePage = getpage().getInstance(LoginPage.class).doLogin(excelReader.getSingleCellData("TestingData",0,0), excelReader.getSingleCellData("TestingData",0,1));
		String titleH = homePage.getHomePageTitle();
		System.out.println("Home page title is: "+titleH);
		Assert.assertEquals(titleH, "actiTIME - Open Tasks");
		
		getpage().getInstance(HomePage.class).clickOnLogout();
	}
	
	
	
}
