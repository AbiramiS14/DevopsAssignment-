package com.SeleniumGrid.AssignmentDevops;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelBrowser 
{
	WebDriver driver;
  @Parameters("brname")
  @Test
  public void CrossBrowser(String brname) throws MalformedURLException, InterruptedException 
  {
	if(brname.equalsIgnoreCase("chrome"))
	{
		ChromeOptions options = new ChromeOptions();
		driver = new RemoteWebDriver(new URL("http://localhost:4444"),options);
		System.out.println("Chrome Connection Established");
	}
	if(brname.equalsIgnoreCase("edge"))
	{
		EdgeOptions options = new EdgeOptions();
		driver = new RemoteWebDriver(new URL("http://localhost:4444"),options);
		System.out.println("Edge Connection Established");
	}
	if(brname.equalsIgnoreCase("firefox"))
	{
		FirefoxOptions options = new FirefoxOptions();
		driver = new RemoteWebDriver(new URL("http://localhost:4444"),options);
		System.out.println("Firefox Connection Established");
	}
	Thread.sleep(5000);
	driver.get("https://www.amazon.in");
	Thread.sleep(5000);
	System.out.println("Executed Browser Parallelly");
	driver.quit();
  }
}
