package com.naveen.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveen.page.BasePage;

public class LoginPage extends BasePage
{

	public LoginPage(WebDriver driver) 
	{
		super(driver);	
	}
	
	// page locators
	private By userName = By.name("username");
	private By passWord = By.name("pwd");
	private By loginBtn = By.xpath("//input[@type='submit']");
	private By header   = By.xpath("//div[@id='logo']");
	
	// getter Methods
	public WebElement getUserName() 
	{
		return getElement(userName);
	}
	
	
	public WebElement getPassWord() 
	{
		return getElement(passWord);
	}
	
	
	public WebElement getLoginBtn() 
	{
		return getElement(loginBtn);
	}
	
	public WebElement getHeader() 
	{
		return getElement(header);
	}
	
    // Page Actions
	
	public String getLoginPageTitle()
	{
		return getPageTitle();
	}
	
	public boolean getPageHeader()
	{
		return getPageHeader(header);
	}

	public HomePage doLogin(String un, String pass)
	{
		getUserName().sendKeys(un);
		getPassWord().sendKeys(pass);
		getLoginBtn().click();
		try 
		{
			Thread.sleep(6000);
		} 
		catch(InterruptedException e) 
		{
	    	e.printStackTrace();
		}
		return getInstance(HomePage.class);
	}
	
}
