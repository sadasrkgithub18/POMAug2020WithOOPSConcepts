package com.naveen.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveen.page.BasePage;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver) 
	{
		super(driver);
		
	}

	
	// page locators
	private By header = By.name("normalSupportMenuImg");

	private By projectsAndCustomers = By.linkText("Projects & Customers");

	private By logOut = By.className("logoutImg");


	

	// getters
	public By getHeader() 
	{
		return header;
	}

	public WebElement getProjectsAndCustomers() 
	{
		return getElement(projectsAndCustomers);
	}

	public WebElement getLogOut() 
	{
		return getElement(logOut);
	}
	
	// page actions
	public String getHomePageTitle()
	{
		return getPageTitle();	
	}
	
	public boolean getHomePageHeader()
	{
		return getPageHeader(header);	
	}
	
	// page Actions
	public ProjectsAndCustomersPage clickOnProjAndCust()
	{
		getProjectsAndCustomers().click();
		
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		return getInstance(ProjectsAndCustomersPage.class);
	}
	
	public void clickOnLogout()
	{
		getLogOut().click();
		
		
	}
	
}
