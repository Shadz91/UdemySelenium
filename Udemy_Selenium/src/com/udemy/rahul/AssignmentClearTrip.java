package com.udemy.rahul;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AssignmentClearTrip {
	@Test
	public void clearTripTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");

		Select Adults = new Select(driver.findElement(By.id("Adults")));
		Adults.selectByIndex(1);
		Select Children = new Select(driver.findElement(By.id("Childrens")));
		Children.selectByIndex(1);

		driver.findElement(By.id("DepartDate")).click();
		List<WebElement> allDates = driver.findElements(By.xpath("(//table[@class='calendar'])[1]//td"));
		for (WebElement element : allDates) {
			if (element.getText().equals("8")) {
				element.click();
				break;
			}
		}

		driver.findElement(By.xpath("//*[@title='More search options']")).click();
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Indigo");
		driver.findElement(By.id("SearchBtn")).click();
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
	}
}