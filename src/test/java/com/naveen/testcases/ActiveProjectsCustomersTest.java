package com.naveen.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.naveen.supporters.ExcelReader;
import com.naveen.tests.BaseEngine;
import com.naveen.util.FilePaths;
import com.naveen.webpages.AddNewCustomerPage;
import com.naveen.webpages.EditCustomerInformationPage;
import com.naveen.webpages.HomePage;
import com.naveen.webpages.LoginPage;
import com.naveen.webpages.ProjectsAndCustomersPage;

public class ActiveProjectsCustomersTest extends BaseEngine
{
	public ExcelReader excelReader;
	   
     @Test
     public void createCustomerTest()
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
	    
	   getpage().getInstance(HomePage.class).clickOnProjAndCust();
	   
	   AddNewCustomerPage addNewCust = getpage().getInstance(ProjectsAndCustomersPage.class).clickOnAddNewCustomer();
	   
	   addNewCust.enterCustomerName("SRK");
	   addNewCust.enterCustomerDesc("SRK Desc");
	   ProjectsAndCustomersPage projAndCustPage = addNewCust.clickOnCreateCustomerBtn();
	    
	   String sucMsg = projAndCustPage.getCustCreationSuccessMsg();
	   Assert.assertEquals(sucMsg, "Customer has been successfully registered.");
	   
	   getpage().getInstance(HomePage.class).clickOnLogout();
    }
     
     
     @Test
     public void deleteCustomer()
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
	    
	   ProjectsAndCustomersPage projAndCust =  getpage().getInstance(HomePage.class).clickOnProjAndCust();
	   EditCustomerInformationPage editCustInfo = projAndCust.clickOnDelCustLinkSRK();
	   
	   projAndCust = editCustInfo.clickOnDeleteCustomer();
	   
	   String delSucc =  projAndCust.getCustDeletionSuccessMsg();
	   Assert.assertEquals(delSucc, "Customer has been successfully deleted.");
	   
	   getpage().getInstance(HomePage.class).clickOnLogout();
     }
}
