package com.naveen.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveen.page.BasePage;

public class ProjectsAndCustomersPage extends BasePage
{

	public ProjectsAndCustomersPage(WebDriver driver) 
	{
		super(driver);
	}

	
	// page locators
	private By addNewCust = By.xpath("//input[@value='Add New Customer']");
	
	private By custSuccessMsg = By.className("successmsg");
	
	private By custDelSuccessMsg = By.className("successmsg");
	
	

	private By delCustSRK = By.linkText("SRK");
	
	//getters
	public WebElement getDelCustSRK() 
	{
		return getElement(delCustSRK);
	}
	
	public WebElement getCustDelSuccessMsg() 
	{
		return getElement(custDelSuccessMsg);
	}



	public WebElement getCustSuccessMsg() 
	{
		return getElement(custSuccessMsg);
	}

	public WebElement getAddNewCust() 
	{
		return getElement(addNewCust);
	}
	
	// page Actions
	
	public String getProjectsAndCustomersPageTitle()
	{
		return getPageTitle();
	}
	
	public AddNewCustomerPage clickOnAddNewCustomer()
	{
		getAddNewCust().click();
		
		return getInstance(AddNewCustomerPage.class);
	}
	
	public String getCustCreationSuccessMsg()
	{
		return getCustSuccessMsg().getText();
	}
	
	public String getCustDeletionSuccessMsg()
	{
		return getCustDelSuccessMsg().getText();
	}

	public EditCustomerInformationPage clickOnDelCustLinkSRK()
	{
		getDelCustSRK().click();
		
		return getInstance(EditCustomerInformationPage.class);
	}
	
}
