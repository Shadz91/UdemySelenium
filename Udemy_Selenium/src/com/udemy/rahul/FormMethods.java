package com.udemy.rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FormMethods {
	@Test
	public void isDisplayedTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");

		System.out.println("Before Clicking on MULTI-CITY Radio Button");
		System.out.println(driver.findElement(By.xpath("//*[@id='hp-widget__return']")).isDisplayed()); // True

		driver.findElement(By.xpath("//*[text()='multi-city']")).click();

		System.out.println("After Clicking on MULTI-CITY Radio Button");
		System.out.println(driver.findElement(By.xpath("//*[@id='hp-widget__return']")).isDisplayed()); // False

		driver.findElement(By.xpath("//*[text()='round trip']")).click();

		System.out.println("Back to Normal");
		System.out.println(driver.findElement(By.xpath("//*[@id='hp-widget__return']")).isDisplayed()); // True

		// System.out.println(driver.findElement(By.xpath("//*[text()='mui-city']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[text()='Discover Hot Deals']")).getText());
	}
}