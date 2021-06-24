package com.pillow.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pillow.qa.base.TestBase;
import com.pillow.qa.util.Xls_Reader;

public class CheckoutPage extends TestBase {
	
	Xls_Reader reader;
	
	@FindBy(xpath ="//div[contains(text(),'Credit/Debit Card')]")
	WebElement card;
	
	@FindBy(xpath="//input[@name='cardnumber']")
	WebElement cardnumber;
	
	@FindBy(xpath="(//input[@type='tel'])[2]")
	WebElement date;
	
	@FindBy(xpath="(//input[@type='tel'])[3]")
	WebElement cvv;
	
	@FindBy(xpath="//a[@class='button-main-content']")
	WebElement paynow;
	
	@FindBy(xpath="//input[@id='PaRes']")
	WebElement pass;
	
	@FindBy(xpath="//button[@name='ok']")
	WebElement ok;
	
	
	
	public CheckoutPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void payment() throws InterruptedException
	{
		
		Thread.sleep(3000);
		card.click();
		
		reader = new Xls_Reader("C:\\Users\\Neosoft\\eclipse-workspace\\Pilow\\src\\main\\java\\com\\pillow\\qa\\util\\Sheet.xlsx");
		String sheetName = "Sheet1";
		
	//	System.out.println(reader.getCellData(sheetName, 2, 2));		
		cardnumber.clear();
		cardnumber.sendKeys(reader.getCellData(sheetName, 1, 2));
		date.clear();
		date.sendKeys(reader.getCellData(sheetName, 2, 2));
		cvv.clear();
		cvv.sendKeys(reader.getCellData(sheetName, 3, 2));
		paynow.click();
		
		Thread.sleep(5000);
	//	driver.switchTo().frame(pass);
		WebDriverWait wait1=new WebDriverWait(driver,120);
  	  	wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//iframe"))));
		pass.sendKeys(reader.getCellData(sheetName, 4, 2));
		ok.click();
	}
	
}
