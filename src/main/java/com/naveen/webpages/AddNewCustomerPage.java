package com.naveen.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveen.page.BasePage;

public class AddNewCustomerPage extends BasePage
{

	public AddNewCustomerPage(WebDriver driver) 
	{
		super(driver);
	}
	
	// page locators
	private By customerName = By.name("name");

	private By customerDesc = By.name("description");
	
	private By createCustomer = By.name("createCustomerSubmit");

	
	
	// getters
	public WebElement getCustomerName() 
	{
		return getElement(customerName);
	}

	public WebElement getCustomerDesc() 
	{
		return getElement(customerDesc);
	}

	public WebElement getCreateCustomer() 
	{
		return getElement(createCustomer);
	}
	
	// page Actions
	
	public String getAddNewCustomerPage()
	{
		return getPageTitle();
	}
	
	public void enterCustomerName(String name)
	{
		getCustomerName().sendKeys(name);
	}
	
	public void enterCustomerDesc(String name)
	{
		getCustomerDesc().sendKeys(name);
	}
	
	public ProjectsAndCustomersPage clickOnCreateCustomerBtn()
	{
		getCreateCustomer().click();
		
		return getInstance(ProjectsAndCustomersPage.class);
	}
	
}
