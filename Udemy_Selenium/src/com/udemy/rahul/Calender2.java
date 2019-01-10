package com.udemy.rahul;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Calender2 {
	@Test
	public void calenderTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companions");
		// April 22nd
		driver.findElement(By.xpath("//*[@id='travel_date']")).click();

		// Month Identification --- April
		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
				.contains("April")) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
		}

		List<WebElement> allDates = driver.findElements(By.xpath("//*[contains(@class,'day')]")); // Important
		for (WebElement element : allDates) {
			String date = element.getText();
			if (date.equals("22")) {
				element.click();
				break;
			}
		}

	}
}
