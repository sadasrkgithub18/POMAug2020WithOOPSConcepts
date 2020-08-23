package com.naveen.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page
{

	
	public BasePage(WebDriver driver) 
	{
		super(driver);
	}
	
	@Override
	public String getPageTitle() 
	{
		return driver.getTitle();
	}

	@Override
	public boolean getPageHeader(By locator) 
	{
		return getElement(locator).isDisplayed();
	}

	@Override
	public WebElement getElement(By locator) 
	{
		WebElement element = null;
		try 
		{
		  waitForElementPresent(locator);
		  element = driver.findElement(locator);
		  return element;
		}
		catch(Exception e)
		{
			System.out.println("Some error occured while locating element: "+locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) 
	{
		try 
		{
		  	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch(Exception e)
		{
			System.out.println("Some error occured while waiting for the element "+locator.toString());
		}
	}

	@Override
	public void waitForPageTitle(String title) 
	{
		try 
		{
		  	wait.until(ExpectedConditions.titleContains(title));
		}
		catch(Exception e)
		{
			System.out.println("Some error occured while waiting for the element "+title);
		}
	}

	public void alertHandling()
	{
		driver.switchTo().alert().accept();
	}
	
}
