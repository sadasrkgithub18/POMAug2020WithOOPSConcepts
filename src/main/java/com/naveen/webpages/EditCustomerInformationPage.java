package com.naveen.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveen.page.BasePage;

public class EditCustomerInformationPage extends BasePage
{

	public EditCustomerInformationPage(WebDriver driver) 
	{
		super(driver);
	}

	
	// page locators
	private By delCustomerBtn = By.xpath("//input[@value='Delete This Customer']"); 
	
	// getters
	public WebElement getDelCustomerBtn() 
	{
		return getElement(delCustomerBtn);
	}

	// page actions
	public String getEditCustomerInformationPage()
	{
		return getPageTitle();
	}
	
	public ProjectsAndCustomersPage clickOnDeleteCustomer()
	{
		getDelCustomerBtn().click();
		
		alertHandling();
		
		return getInstance(ProjectsAndCustomersPage.class);
	}
}
