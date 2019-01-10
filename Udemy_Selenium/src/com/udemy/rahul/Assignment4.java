package com.udemy.rahul;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment4 {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://qaclickacademy.com/practice.php");
	}

	@Test
	public void checkboxTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
		String option2 = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();

		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(option2);
		Thread.sleep(3000);

		driver.findElement(By.id("name")).sendKeys(option2);
		Thread.sleep(3000);
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertTrue(alertText.contains(option2)); // Important
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
