package com.pillow.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pillow.qa.base.TestBase;
import com.pillow.qa.pages.CheckoutPage;
import com.pillow.qa.pages.HomePage;

public class CheckoutpageTest extends TestBase{
	
	CheckoutPage checkout;

	
	
	@BeforeMethod
	@Parameters("browserName")
	public WebDriver setup(String browserName) throws InterruptedException
	{
		initialization(browserName);
		homepage = new HomePage();
		checkout = new CheckoutPage();
		return driver;
	}	
	
	
	@Test
	public void paynowTest() throws InterruptedException
	{
		homepage.cart();
		checkout.payment();
	}
	

}
