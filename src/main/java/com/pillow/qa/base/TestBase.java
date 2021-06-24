package com.pillow.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.pillow.qa.pages.CheckoutPage;
import com.pillow.qa.pages.HomePage;
import com.pillow.qa.util.TestUtil;

public class TestBase {
	
	public static HomePage homepage;
	public static CheckoutPage checkout;
	
	public static WebDriver driver;
	public static Properties prop;
	

	
	public TestBase()
	{
		try 
		{
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\Neosoft\\eclipse-workspace\\Pilow\\src\\main\\java\\com\\pillow\\qa\\config\\config.properties");
		prop.load(ip);
		}
		catch(FileNotFoundException e)
		{ e.printStackTrace();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	/*
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Software Testing\\chromedriver.exe");	
				driver = new ChromeDriver();
		}
		
		
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Software Testing\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}	
		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}*/

		
		public static WebDriver initialization(String browserName) throws InterruptedException
		{
			System.out.println("BrowserName is:"+browserName);
			System.out.println("Thread id:"+Thread.currentThread().getId());
			
			if(browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Software Testing\\chromedriver.exe");	
				ChromeOptions options=new ChromeOptions();
				options.setExperimentalOption("useAutomationExtension", false);
		        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		        options.addArguments("--disable-infobars");
		        options.addArguments("--start-maximized");
		        options.addArguments("--ignore-certificate-errors");
		        options.addArguments("--disable-popup-blocking");
				driver = new ChromeDriver(options);
				driver.get(prop.getProperty("url"));


			}
			
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Software Testing\\geckodriver.exe");	
				FirefoxOptions options=new FirefoxOptions();
				
		        options.addArguments("--disable-infobars");
		        options.addArguments("--start-maximized");
		        options.addArguments("--ignore-certificate-errors");
		        options.addArguments("--disable-popup-blocking");

				driver = new FirefoxDriver(options);
				driver.get(prop.getProperty("url"));


			}
			
			return driver;

		
	}
	
	
	}
	

