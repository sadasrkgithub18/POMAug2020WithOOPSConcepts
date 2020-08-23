package com.naveen.tests;

import com.naveen.page.BasePage;
import com.naveen.page.Page;

public class ActionEngine extends BaseEngine
{
	public static Page page;
	
	   public static void enterURL(String url)
	   {
		   getDriver().get(url);
		   page = new BasePage(getDriver());
	   }
}
