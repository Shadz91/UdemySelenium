package com.udemy.rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment3 {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
	}

	@Test
	public void explicitWaitTest() {
		driver.findElement(By.xpath("//a[contains(text(),'Click to load')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		System.out.println(
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='results']"))).getText());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}