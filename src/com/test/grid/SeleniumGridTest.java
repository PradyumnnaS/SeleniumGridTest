package com.test.grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumGridTest {

	
	public WebDriver driver;
	public String url;
	public String browser;
	public String version;
	public String platform;
	
	@BeforeTest
	public void initDriver() throws MalformedURLException {
		
		ApplicationInfo appinfo = new ApplicationInfo();
		appinfo.setBROWSER("chrome");
		appinfo.setURL("http://toolsqa.com");
		
		url = appinfo.getURL();
		browser = appinfo.getBROWSER();
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			System.out.println("Running in Chrome");
			String nodeurl= "http://192.168.1.4:5566/wd/hub";
			System.setProperty("webdriver.chrome.driver", "G:\\Selenium-Java-Jar\\chromedriver_win32\\chromedriver.exe");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName(browser);
			cap.setPlatform(Platform.WIN10);
			
			driver = new RemoteWebDriver(new URL(nodeurl),cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to(url);
			driver.manage().window().maximize();
			
			
		}else if(browser.equalsIgnoreCase("ie")) {
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
		}else {
			throw new IllegalArgumentException("Browser not provided");
		}
			
		
	}
	
	@Test(enabled=false,priority=1)
	public void testTitlePage() {
		
		String title="QA Automation Tools Tutorial";
		
		String apptitle= driver.getTitle();
		System.out.println("Title of Page is="+apptitle);
		
		Assert.assertEquals(apptitle, title, "Title of page not correct");
	}
	
	@Test(priority=2)
	public void testmessage() {
		System.out.println("Test Message");
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
}
