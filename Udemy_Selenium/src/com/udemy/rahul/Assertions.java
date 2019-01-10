package com.udemy.rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {
	@Test
	public void assertionsTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");

		System.out.println("Before Clicking on MULTI-CITY Radio Button");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='hp-widget__return']")).isDisplayed()); // Important

		driver.findElement(By.xpath("//*[text()='multi-city']")).click();

		System.out.println("After Clicking on MULTI-CITY Radio Button");
		Assert.assertFalse(driver.findElement(By.xpath("//*[@id='hp-widget__return']")).isDisplayed()); // Important

		driver.findElement(By.xpath("//*[text()='round trip']")).click();

		System.out.println("Back to Normal");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='hp-widget__return']")).isDisplayed()); // Important
	}
}