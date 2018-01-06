package com.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPriority extends Assert {
	
	private WebDriver driver = null;
	
	@Test(priority=1)
	public void testCaseMakeDriver() {
		driver = new FirefoxDriver();
	}
	
	@Test(priority=2)
	public void testCaseNavigate() {
		driver.get("http://localhost:5001/");
	}
	
	@Test(priority=2)
	public void testCaseNavigateTwo() {
		driver.get("http://localhost:5001/");
	}
	
	
	
	@Test(priority=3)
	public void testCaseLogin() {
		driver.findElement(By.id("login_link_top")).click();
		driver.quit();
	}

}
