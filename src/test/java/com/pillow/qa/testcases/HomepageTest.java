package com.pillow.qa.testcases;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pillow.qa.base.TestBase;
import com.pillow.qa.pages.CheckoutPage;
import com.pillow.qa.pages.HomePage;

public class HomepageTest extends TestBase{
	
	HomePage homepage;
	CheckoutPage checkout;
	
	
	@BeforeMethod
	@Parameters("browserName")
	public WebDriver setup(String browserName ) throws InterruptedException
	{
		initialization(browserName);
		homepage = new HomePage();
		return driver;
	}
	
	
	@Test(priority=1)
	public void logoTest()
	{
		boolean flag = homepage.validatelogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void shoppingcartTest()
	{
		homepage.cart();
	}
	
	/*
	 * @AfterMethod public void tearDown() { driver.quit(); }
	 */
	 

}
