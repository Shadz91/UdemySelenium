package com.udemy.rahul;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class Assignment5 {

	@Test
	public void autoTest() throws InterruptedException {
		System.setProperty("wedriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://qaclickacademy.com/practice.php");

		driver.findElement(By.xpath("//*[@class='inputs ui-autocomplete-input']")).sendKeys("ind");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='inputs ui-autocomplete-input']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//*[@class='inputs ui-autocomplete-input']")).sendKeys(Keys.DOWN);
		System.out.println(
				driver.findElement(By.xpath("//*[@class='inputs ui-autocomplete-input']")).getAttribute("value"));
	}
}