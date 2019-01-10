package com.udemy.rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class StaticDropdownTest {
	@Test
	public void staticTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Select s = new Select(driver.findElement(By.id("day")));
		s.selectByValue("2");
		s.selectByIndex(6);
		s.selectByVisibleText("5");
	}
}
