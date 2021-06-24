package com.pillow.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.pillow.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="(//a[@href='#'])[1]")
	WebElement Buy;

	@FindBy(xpath="//input[@class='text-right']")
	WebElement Amt;
	
	@FindBy(xpath="(//input[@type=\"text\"])[1]")
	WebElement name;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement email;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement phn;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement city;
	
	@FindBy(xpath="//textarea[@data-reactid='.0.0.1.0.3.0.0.4.1.0']")
	WebElement Addr;
	
	@FindBy(xpath="//input[@value='10220']")
	WebElement postal;
	
	@FindBy(xpath="//div[text()='CHECKOUT']")
	WebElement check;
	
	@FindBy(xpath="//iframe[@id='snap-midtrans']")
	WebElement contin;

	@FindBy(xpath="//div[contains(@class,'titlet')]")
	WebElement logo;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validatelogo()
	{
		return logo.isDisplayed();
	}
	
	public void cart()
	{
		Buy.click();
		Amt.click();
		
		/*
		  name.clear();
		  name.sendKeys("Budi"); 
		  email.clear();
		  email.sendKeys("budi@utomo.com"); 
		  phn.clear();
		  phn.sendKeys("081808466410");
		  city.clear(); 
		  city.sendKeys("jakarta"); 
		  Addr.clear();
		  Addr.sendKeys("MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11");
		  postal.clear(); 
		  postal.sendKeys("10220");
		 */
		
		//Faker class
		Faker faker = new Faker();
		
		String firstname= faker.name().firstName();
		String emailid = faker.internet().emailAddress();
		String phoneNumber = faker.phoneNumber().phoneNumber();
		String cityc= faker.address().city();
		String address = faker.address().fullAddress();
		String postal1 = faker.address().zipCode();
		
		name.clear();
		name.sendKeys(firstname);
		email.clear();
		email.sendKeys(emailid);
		phn.clear();
		phn.sendKeys(phoneNumber);
		city.clear();
		city.sendKeys(cityc);
		Addr.clear();
		Addr.sendKeys(address);
		postal.clear();
		postal.sendKeys(postal1);
		check.click();
		
		
		driver.switchTo().frame(contin);
		WebDriverWait wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button-main-content']"))).click();
		
		

	}
	
	
}
