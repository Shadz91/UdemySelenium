package com.udemy.rahul;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Calender {
	@Test
	public void calenderTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");

		driver.findElement(By.xpath("//*[@id='hp-widget__depart']")).click();
		List<WebElement> allDates = driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[1]//td"));
		for (WebElement element : allDates) {
			String date = element.getText();
			if (date.equals("15")) {
				element.click();
				break;
			}
		}

	}
}
